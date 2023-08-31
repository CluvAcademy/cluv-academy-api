package com.ec.cluv.academy.service.service.academy;

import com.ec.cluv.academy.model.dto.academy.ClaseDto;
import com.ec.cluv.academy.model.dto.auxiliares.ClaseLandingDto;
import com.ec.cluv.academy.service.GenericService;

import java.util.List;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface ClaseService extends GenericService<ClaseDto, Long> {

    List<ClaseLandingDto> getAllClasesLanding();

}
