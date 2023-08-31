package com.ec.cluv.academy.service.service.publick;

import com.ec.cluv.academy.model.dto.publick.RefreshTokenDto;

import java.util.List;


/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface RefreshTokenService {

	
	List<RefreshTokenDto>  listar();
	RefreshTokenDto registrar(RefreshTokenDto obj);
}
