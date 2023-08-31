package com.ec.cluv.academy.controllers.academy;

import com.ec.cluv.academy.model.dto.academy.HorarioSugeridoTutorDto;
import com.ec.cluv.academy.model.enums.EnumMessages;
import com.ec.cluv.academy.model.response.ResponseGenerico;
import com.ec.cluv.academy.service.service.academy.HorarioSugeridoTutorService;
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
@RequestMapping("private/HorarioSugeridoTutor")
public class HorarioSugeridoTutorRest {

    @Autowired
    private HorarioSugeridoTutorService service;


    /**
     * REST para guardar o actualizar
     *
     * @return guardar
     */
    @PostMapping(value = "guardar")
    public ResponseEntity<?> create(@RequestBody HorarioSugeridoTutorDto obj) throws Exception {
        HorarioSugeridoTutorDto dto = service.create(obj);
        ResponseGenerico<HorarioSugeridoTutorDto> response = new ResponseGenerico<>();
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
        ResponseGenerico<HorarioSugeridoTutorDto> response = new ResponseGenerico<>();
        try {
            List<HorarioSugeridoTutorDto> lista = service.findAll();
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
        ResponseGenerico<HorarioSugeridoTutorDto> response = new ResponseGenerico<>();
        try {
            HorarioSugeridoTutorDto dto = service.findById((long) id);
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
