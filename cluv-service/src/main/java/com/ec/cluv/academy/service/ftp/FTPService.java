package com.ec.cluv.academy.service.ftp;


import com.ec.cluv.academy.service.exceptions.FTPErrors;

import java.io.IOException;
import java.io.InputStream;

public interface FTPService {
    void connectToFTP() throws FTPErrors;
    void uploadFileToFTP(InputStream input, String ftpHostDir , String serverFilename) throws FTPErrors;
    void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
    void disconnectFTP() throws FTPErrors;
    byte[] downFileByte(String remotePath, String fileName) throws FTPErrors, IOException;

    }
