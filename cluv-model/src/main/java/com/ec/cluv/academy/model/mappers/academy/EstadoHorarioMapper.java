package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoHorarioDto;
import com.ec.cluv.academy.model.entities.academy.EstadoHorario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoHorarioMapper extends EntityMapper<EstadoHorarioDto, EstadoHorario> {
    

    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    EstadoHorario toEntity(EstadoHorarioDto dto);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    EstadoHorarioDto toDto(EstadoHorario entity);

    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    List<EstadoHorario> toEntity(List<EstadoHorarioDto> dtoList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    List<EstadoHorarioDto> toDto(List<EstadoHorario> entityList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    Set<EstadoHorarioDto> toDto(Set<EstadoHorario> entityList);
}
