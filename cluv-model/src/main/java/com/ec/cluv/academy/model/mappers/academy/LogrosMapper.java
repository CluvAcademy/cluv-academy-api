package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstudianteDto;
import com.ec.cluv.academy.model.dto.academy.LogrosDto;
import com.ec.cluv.academy.model.dto.academy.TiposLogrosDto;
import com.ec.cluv.academy.model.entities.academy.Logros;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface LogrosMapper extends EntityMapper<LogrosDto, Logros> {

    @Mappings({
            @Mapping(source = "idEstudianteDto", target = "idEstudiante"),
            @Mapping(source = "idTipoLogroDto", target = "idTipoLogro")
    })
    @Override
    Logros toEntity(LogrosDto dto);

    @Mappings({
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idTipoLogro", target = "idTipoLogroDto")
    })
    @Override
    LogrosDto toDto(Logros entity);

    @Mappings({
            @Mapping(source = "idEstudianteDto", target = "idEstudiante"),
            @Mapping(source = "idTipoLogroDto", target = "idTipoLogro")
    })
    @Override
    List<Logros> toEntity(List<LogrosDto> dtoList);

    @Mappings({
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idTipoLogro", target = "idTipoLogroDto")
    })
    @Override
    List<LogrosDto> toDto(List<Logros> entityList);

    @Mappings({
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idTipoLogro", target = "idTipoLogroDto")
    })
    @Override
    Set<LogrosDto> toDto(Set<Logros> entityList);
}
