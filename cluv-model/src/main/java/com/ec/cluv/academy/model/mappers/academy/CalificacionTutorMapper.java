package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.CalificacionTutorDto;
import com.ec.cluv.academy.model.entities.academy.CalificacionTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface CalificacionTutorMapper extends EntityMapper<CalificacionTutorDto, CalificacionTutor> {

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    CalificacionTutor toEntity(CalificacionTutorDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    CalificacionTutorDto toDto(CalificacionTutor entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<CalificacionTutor> toEntity(List<CalificacionTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<CalificacionTutorDto> toDto(List<CalificacionTutor> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<CalificacionTutorDto> toDto(Set<CalificacionTutor> entityList);
}
