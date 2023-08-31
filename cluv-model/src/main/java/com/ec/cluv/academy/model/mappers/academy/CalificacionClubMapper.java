package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.CalificacionClubDto;
import com.ec.cluv.academy.model.entities.academy.CalificacionClub;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface CalificacionClubMapper extends EntityMapper<CalificacionClubDto, CalificacionClub> {

    @Mappings({
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    CalificacionClub toEntity(CalificacionClubDto dto);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    CalificacionClubDto toDto(CalificacionClub entity);

    @Mappings({
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    List<CalificacionClub> toEntity(List<CalificacionClubDto> dtoList);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    List<CalificacionClubDto> toDto(List<CalificacionClub> entityList);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    Set<CalificacionClubDto> toDto(Set<CalificacionClub> entityList);
}
