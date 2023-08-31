package com.ec.cluv.academy.service.service.publick;

import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.service.GenericService;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface UsuarioService extends GenericService<UsuarioDto, Integer> {

    public UsuarioDto findByNombreUsuario(String username);
    public UsuarioDto findByDni(String dni);
}
