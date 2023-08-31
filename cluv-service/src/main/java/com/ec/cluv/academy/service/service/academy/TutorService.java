package com.ec.cluv.academy.service.service.academy;

import com.ec.cluv.academy.model.dto.academy.TutorDto;
import com.ec.cluv.academy.model.dto.auxiliares.TutorLandingDto;
import com.ec.cluv.academy.service.GenericService;

import java.util.List;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface TutorService extends GenericService<TutorDto, Long> {

    List<TutorLandingDto> getAllTutorLandingDto();

}
