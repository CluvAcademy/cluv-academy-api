package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.DiasHorarioDto;
import com.ec.cluv.academy.model.entities.academy.DiasHorario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface DiasHorarioMapper extends EntityMapper<DiasHorarioDto, DiasHorario> {

    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    DiasHorario toEntity(DiasHorarioDto dto);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    DiasHorarioDto toDto(DiasHorario entity);

    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    List<DiasHorario> toEntity(List<DiasHorarioDto> dtoList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    List<DiasHorarioDto> toDto(List<DiasHorario> entityList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    Set<DiasHorarioDto> toDto(Set<DiasHorario> entityList);
}
