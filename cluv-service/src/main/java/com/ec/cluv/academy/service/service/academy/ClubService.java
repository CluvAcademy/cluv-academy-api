package com.ec.cluv.academy.service.service.academy;

import com.ec.cluv.academy.model.dto.academy.ClubDto;
import com.ec.cluv.academy.model.dto.auxiliares.ClubLandingDto;
import com.ec.cluv.academy.service.GenericService;

import java.util.List;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface ClubService extends GenericService<ClubDto, Long> {

    List<ClubLandingDto> getAllClubLandingDto();

}
