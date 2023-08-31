package com.ec.cluv.academy.controllers.utils;

import com.ec.cluv.academy.model.response.ResponseGenerico;
import com.ec.cluv.academy.service.exceptions.FTPErrors;
import com.ec.cluv.academy.service.ftp.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ec.cluv.academy.model.enums.EnumFtp.*;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.OPTIONS})
@RequestMapping(value = "private/files")
public class FilesController {

    @Autowired
    private FTPService ftpService;

    @RequestMapping(value = "/upload/{proceso}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile[] files, @PathVariable String proceso) throws FTPErrors, IOException {
        ResponseGenerico response = new ResponseGenerico();
        try {
            //TODO: añadir en la base datos procesos o diferentes ftp para los diferentes procesos
            //TODO: con el proceso se debe cambiar la conexion a ftp
            ftpService.connectToFTP();
            //TODO: se deben obtener el path remoto desde la base de datos
            String pathFtp = "/laboratorios/" + proceso + "/";
            //List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                ftpService.uploadFileToFTP(file.getInputStream(), pathFtp, fileName);
                fileNames.add(fileName);
            }
            ftpService.disconnectFTP();

            response.setCodigoRespuestaName(HttpStatus.OK.name());
            response.setCodigoRespuestaValue(HttpStatus.OK.value());
            response.setMensaje(SUCCESS_UPLOAD.getValor() + ":" + fileNames);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setCodigoRespuestaName(HttpStatus.EXPECTATION_FAILED.name());
            response.setCodigoRespuestaValue(HttpStatus.EXPECTATION_FAILED.value());
            response.setMensaje(ERROR_UPLOAD.getValor());
            return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);

        }
    }

    @GetMapping("/fileByName/{fileName}/{proceso}")
    public ResponseEntity<?> getFiles(@PathVariable("fileName") String fileName, @PathVariable("proceso") String proceso) throws FTPErrors, IOException {
        String message = "";
        ResponseGenerico response = new ResponseGenerico();

        try {
            //TODO: añadir en la base datos procesos o diferentes ftp para los diferentes procesos
            //TODO: con el proceso se debe cambiar la conexion a ftp
            ftpService.connectToFTP();
            //TODO: se deben obtener el path remoto desde la base de datos
            String pathFtp = "/laboratorios/" + proceso + "/";
            byte[] file = ftpService.downFileByte(pathFtp, fileName);
            ftpService.disconnectFTP();

            response.setObjeto(file);
            response.setCodigoRespuestaName(HttpStatus.OK.name());
            response.setCodigoRespuestaValue(HttpStatus.OK.value());
            response.setMensaje(SUCCESS_UPLOAD.getValor() + ":" + fileName);
            //return new ResponseEntity<>(response, HttpStatus.OK);

            return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).body(file);

        } catch (Exception e) {
            message = "Fallo al subir los archivos";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }
}
