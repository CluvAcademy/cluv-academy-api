package com.ec.cluv.academy.controllers.academy;

import com.ec.cluv.academy.model.dto.academy.CalificacionClubDto;
import com.ec.cluv.academy.model.enums.EnumMessages;
import com.ec.cluv.academy.model.response.ResponseGenerico;
import com.ec.cluv.academy.service.service.academy.CalificacionClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest para el manejo de transacccion
 *
 * @author Wilson Castro
 */
@RestController
@RequestMapping("private/CalificacionClub")
public class CalificacionClubRest {

    @Autowired
    private CalificacionClubService service;


    /**
     * REST para guardar o actualizar
     *
     * @return guardar
     */
    @PostMapping(value = "guardar")
    public ResponseEntity<?> create(@RequestBody CalificacionClubDto obj) throws Exception {
        CalificacionClubDto dto = service.create(obj);
        ResponseGenerico<CalificacionClubDto> response = new ResponseGenerico<>();
        try {
            response.setCodigoRespuestaName(HttpStatus.OK.name());
            response.setCodigoRespuestaValue(HttpStatus.OK.value());
            response.setObjeto(dto);
            response.setMensaje(EnumMessages.INGRESO_EXITOSO.getValor());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setCodigoRespuestaName(HttpStatus.BAD_REQUEST.name());
            response.setCodigoRespuestaValue(HttpStatus.BAD_REQUEST.value());
            response.setMensaje(EnumMessages.INGRESO_FALLIDO.name() + ":" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


    }

    /**
     * Metodo para listar todo
     *
     * @return objeto response
     */
    @GetMapping(value = "listar")
    public ResponseEntity<?> listar() {
        ResponseGenerico<CalificacionClubDto> response = new ResponseGenerico<>();
        try {
            List<CalificacionClubDto> lista = service.findAll();
            response.setCodigoRespuestaName(HttpStatus.OK.name());
            response.setCodigoRespuestaValue(HttpStatus.OK.value());
            response.setListado(lista);
            response.setTotalRegistros((long) lista.size());
            response.setMensaje(EnumMessages.REGISTRO_EXISTENTE.name());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setCodigoRespuestaName(HttpStatus.BAD_REQUEST.name());
            response.setCodigoRespuestaValue(HttpStatus.BAD_REQUEST.value());
            response.setMensaje(EnumMessages.REGISTRO_NO_EXISTENTE.name() + ":" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Metodo para buscar por ID PK
     *
     * @return objeto response
     */
    @GetMapping(value = "buscarPorId/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        ResponseGenerico<CalificacionClubDto> response = new ResponseGenerico<>();
        try {
            CalificacionClubDto dto = service.findById((long) id);
            response.setCodigoRespuestaName(HttpStatus.OK.name());
            response.setCodigoRespuestaValue(HttpStatus.OK.value());
            response.setObjeto(dto);
            response.setMensaje(EnumMessages.REGISTRO_EXISTENTE.name());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setCodigoRespuestaName(HttpStatus.BAD_REQUEST.name());
            response.setCodigoRespuestaValue(HttpStatus.BAD_REQUEST.value());
            response.setMensaje(EnumMessages.REGISTRO_NO_EXISTENTE.name() + ":" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}