package com.ec.cluv.academy.service.ftp;

import com.ec.cluv.academy.service.exceptions.ErrorMessage;
import com.ec.cluv.academy.service.exceptions.FTPErrors;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FileServiceImp implements FTPService {
    /**
     * FTP connection handler
     */
    @Value("${ftp.server}")
    String ftpServer;
    @Value("${ftp.port}")
    String ftpPort;
    @Value("${ftp.userName}")
    String ftpUserName;
    @Value("${ftp.userPassword}")
    String ftpuserPassword;

    FTPClient ftpconnection;
    private Logger logger = LoggerFactory.getLogger(FileServiceImp.class);

    private final static String localpath = "c:/"; // Descarga a la unidad c
    private final static String fileSeparator = System.getProperty("file.separator");


    /**
     * Method that implement FTP connection.
     *
     * @param ftpServer       IP of FTP server
     * @param ftpUserName     FTP valid user
     * @param ftpuserPassword FTP valid pass for user
     * @throws FTPErrors Set of possible errors associated with connection process.
     */
    @Override
    public void connectToFTP() throws FTPErrors {
        ftpconnection = new FTPClient();
        ftpconnection.setControlEncoding("UTF-8");
        ftpconnection.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        try {
            ftpconnection.connect(ftpServer);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-1, "No fue posible conectarse al FTP a través del host=" + ftpServer);
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
        reply = ftpconnection.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            try {
                ftpconnection.disconnect();
            } catch (IOException e) {
                ErrorMessage errorMessage = new ErrorMessage(-2, "No fue posible conectarse al FTP, el host=" + ftpServer + " entregó la respuesta=" + reply);
                logger.error(errorMessage.toString());
                throw new FTPErrors(errorMessage);
            }
        }
        try {
            ftpconnection.login(ftpUserName, ftpuserPassword);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-3, "El usuario=" + ftpUserName + ", y el pass=**** no fueron válidos para la autenticación.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
        try {
            ftpconnection.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-4, "El tipo de dato para la transferencia no es válido.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
        ftpconnection.enterLocalPassiveMode();
    }

    public  String stripAccents(String s)
    {
        /*Salvamos las ñ*/
        s = s.replace('ñ', 'n');
        s = s.replace('Ñ', 'N');
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        /*Volvemos las ñ a la cadena*/
        //s = s.replace('\001', 'ñ');
        // s = s.replace('\002', 'Ñ');

        return s;
    }

    /**
     * Method that allow upload file to FTP
     *
     * @param input          File object of file to upload
     * @param ftpHostDir     FTP host internal directory to save file
     * @param serverFilename Name to put the file in FTP server.
     * @throws FTPErrors Set of possible errors associated with upload process.
     */
    // @Async("threadPoolTaskExecutor")
    @Override
    public void uploadFileToFTP(InputStream input, String ftpHostDir, String serverFilename) throws FTPErrors {
        try {
           serverFilename = new String(serverFilename.getBytes("utf-8"));
            this.ftpconnection.storeFile(ftpHostDir + serverFilename, input);

        } catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage(-5, "No se pudo subir el archivo al servidor.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
    }

    /**
     * Method for download files from FTP.
     *
     * @param ftpRelativePath Relative path of file to download into FTP server.
     * @param copytoPath      Path to copy the file in download process.
     * @throws FTPErrors Set of errors associated with download process.
     */
    @Override
    public void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(copytoPath);
        } catch (FileNotFoundException e) {
            ErrorMessage errorMessage = new ErrorMessage(-6, "No se pudo obtener la referencia a la carpeta relativa donde guardar, verifique la ruta y los permisos.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
        try {
            this.ftpconnection.retrieveFile(ftpRelativePath, fos);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-7, "No se pudo descargar el archivo.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
    }

    /**
     * Method for release the FTP connection.
     *
     * @throws FTPErrors Error if unplugged process failed.
     */
    @Override
    public void disconnectFTP() throws FTPErrors {
        if (this.ftpconnection.isConnected()) {
            try {
                this.ftpconnection.logout();
                this.ftpconnection.disconnect();
            } catch (IOException f) {
                throw new FTPErrors(new ErrorMessage(-8, "Ha ocurrido un error al realizar la desconexión del servidor FTP"));
            }
        }
    }

    Collection<String> listFiles(String path) throws IOException {
        FTPFile[] files = this.ftpconnection.listFiles(path);
        return Arrays.stream(files)
                .map(FTPFile::getName)
                .collect(Collectors.toList());
    }

    @Override
    public byte[] downFileByte(String remotePath, String fileName) throws FTPErrors, IOException {

        byte[] return_arraybyte = null;
        if (remotePath != null && !remotePath.equals("")) {
            remotePath = remotePath;
            this.ftpconnection.changeWorkingDirectory(remotePath);
        }
        try {
            FTPFile[] files = this.ftpconnection.listFiles();
            for (FTPFile file : files) {
                String remoteFileName = new String(file.getName().getBytes("utf-8")); // Evitar caracteres confusos
                if (remoteFileName.equals(fileName)) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    this.ftpconnection.retrieveFile(remotePath + fileName, baos);
                    return_arraybyte = baos.toByteArray();
                    baos.close();
                    return return_arraybyte;
                }
            }
        } catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage(-9, "No se pudo descargar el archivo.");
        }
        return return_arraybyte;

    }


}
