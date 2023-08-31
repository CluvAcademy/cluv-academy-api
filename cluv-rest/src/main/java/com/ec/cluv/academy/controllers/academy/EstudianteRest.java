package com.ec.cluv.academy.controllers.academy;

import com.ec.cluv.academy.model.dto.academy.EstudianteDto;
import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioPKDto;
import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.model.entities.academy.EstadoEstudiante;
import com.ec.cluv.academy.model.entities.publick.Perfil;
import com.ec.cluv.academy.model.enums.EnumMessages;
import com.ec.cluv.academy.model.enums.EnumRole;
import com.ec.cluv.academy.model.response.ResponseGenerico;
import com.ec.cluv.academy.service.service.academy.EstadoEstudianteService;
import com.ec.cluv.academy.service.service.academy.EstudianteService;
import com.ec.cluv.academy.service.service.publick.PerfilService;
import com.ec.cluv.academy.service.service.publick.PerfilUsuarioService;
import com.ec.cluv.academy.service.service.publick.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


/**
 * Rest para el manejo de transacccion
 *
 * @author Wilson Castro
 */
@RestController
@RequestMapping("private/Estudiante")
public class EstudianteRest {

    @Autowired
    private EstudianteService service;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private EstadoEstudianteService estadoEstudianteService;


    /**
     * REST para guardar o actualizar
     *
     * @return guardar
     */
    @PostMapping(value = "guardarEstudianteUsuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDto obj) throws Exception {
        ResponseGenerico<EstudianteDto> response = new ResponseGenerico<>();
        EstudianteDto dto = new EstudianteDto();
        UsuarioDto user = new UsuarioDto();

        user = usuarioService.findByNombreUsuario(obj.getNombreUsuario());
        if (user != null) {
            if (user.getNombreUsuario().equals(obj.getNombreUsuario())){
                response.setCodigoRespuestaName(HttpStatus.IM_USED.name());
                response.setCodigoRespuestaValue(HttpStatus.IM_USED.value());
                response.setMensaje(EnumMessages.DATO_EXISTE.name());
                return new ResponseEntity<>(response, HttpStatus.IM_USED);
            }
        }

        user = usuarioService.findByDni(obj.getCedula());
        if (user != null) {
            if (user.getCedula().equals(obj.getCedula())) {
                response.setCodigoRespuestaName(HttpStatus.FOUND.name());
                response.setCodigoRespuestaValue(HttpStatus.FOUND.value());
                response.setMensaje(EnumMessages.REGISTRO_EXISTENTE.name());
                return new ResponseEntity<>(response, HttpStatus.FOUND);
            }
        }

        user = usuarioService.create(obj);
        if(user != null){

            PerfilUsuarioPKDto pk = new PerfilUsuarioPKDto();
            pk.setIdUsuario(user.getIdUsuario());
            pk.setIdPerfil(EnumRole.USUARIO_ESTUDIANTE.getValor());

            PerfilDto perfilDto = new PerfilDto();
            perfilDto = perfilService.findById(EnumRole.USUARIO_ESTUDIANTE.getValor());

            PerfilUsuarioDto puDto = new PerfilUsuarioDto();
            puDto.setPerfilUsuarioPKDto(pk);
            puDto.setUsuarioDto(user);
            puDto.setPerfilDto(perfilDto);

            perfilUsuarioService.create(puDto);


            dto.setIdUsuarioEstudiante(BigInteger.valueOf(user.getIdUsuario()));
            dto.setActivoEstudiante(true);
            dto.setIdEstadoEstudianteDto(estadoEstudianteService.findById((long) 1));

            service.create(dto);
        }

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

    @PostMapping(value = "guardar")
    public ResponseEntity<?> create(@RequestBody EstudianteDto obj) throws Exception {
        EstudianteDto dto = service.create(obj);
        ResponseGenerico<EstudianteDto> response = new ResponseGenerico<>();
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
        ResponseGenerico<EstudianteDto> response = new ResponseGenerico<>();
        try {
            List<EstudianteDto> lista = service.findAll();
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
        ResponseGenerico<EstudianteDto> response = new ResponseGenerico<>();
        try {
            EstudianteDto dto = service.findById((long) id);
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
