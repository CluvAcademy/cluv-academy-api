package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoEstudianteDto;
import com.ec.cluv.academy.model.entities.academy.EstadoEstudiante;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoEstudianteMapper extends EntityMapper<EstadoEstudianteDto, EstadoEstudiante> {


    @Mappings({
            @Mapping(source = "estudianteCollectionDto", target = "estudianteCollection")
    })
    @Override
    EstadoEstudiante toEntity(EstadoEstudianteDto dto);

    @Mappings({
            @Mapping(source = "estudianteCollection", target = "estudianteCollectionDto")
    })
    @Override
    EstadoEstudianteDto toDto(EstadoEstudiante entity);

    @Mappings({
            @Mapping(source = "estudianteCollectionDto", target = "estudianteCollection")
    })
    @Override
    List<EstadoEstudiante> toEntity(List<EstadoEstudianteDto> dtoList);

    @Mappings({
            @Mapping(source = "estudianteCollection", target = "estudianteCollectionDto")
    })
    @Override
    List<EstadoEstudianteDto> toDto(List<EstadoEstudiante> entityList);

    @Mappings({
            @Mapping(source = "estudianteCollection", target = "estudianteCollectionDto")
    })
    @Override
    Set<EstadoEstudianteDto> toDto(Set<EstadoEstudiante> entityList);
}
