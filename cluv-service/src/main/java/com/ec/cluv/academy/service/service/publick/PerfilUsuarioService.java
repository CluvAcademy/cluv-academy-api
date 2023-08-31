package com.ec.cluv.academy.service.service.publick;

import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioDto;
import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioPKDto;
import com.ec.cluv.academy.service.GenericService;

import java.util.List;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface PerfilUsuarioService extends GenericService<PerfilUsuarioDto, PerfilUsuarioPKDto> {
    public List<PerfilDto> obtenerPorUsername(String username);

}
