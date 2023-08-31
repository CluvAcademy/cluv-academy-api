package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.entities.academy.Horario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface HorarioMapper extends EntityMapper<HorarioDto, Horario> {

    @Mappings({
            @Mapping(source = "diasHorarioDto", target = "diasHorario"),
            @Mapping(source = "idEstadoHorarioDto", target = "idEstadoHorario"),
            @Mapping(source = "horasHorarioDto", target = "horasHorario"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    Horario toEntity(HorarioDto dto);

    @Mappings({
            @Mapping(source = "diasHorario", target = "diasHorarioDto"),
            @Mapping(source = "idEstadoHorario", target = "idEstadoHorarioDto"),
            @Mapping(source = "horasHorario", target = "horasHorarioDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    HorarioDto toDto(Horario entity);

    @Mappings({
            @Mapping(source = "diasHorarioDto", target = "diasHorario"),
            @Mapping(source = "idEstadoHorarioDto", target = "idEstadoHorario"),
            @Mapping(source = "horasHorarioDto", target = "horasHorario"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    List<Horario> toEntity(List<HorarioDto> dtoList);

    @Mappings({
            @Mapping(source = "diasHorario", target = "diasHorarioDto"),
            @Mapping(source = "idEstadoHorario", target = "idEstadoHorarioDto"),
            @Mapping(source = "horasHorario", target = "horasHorarioDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    List<HorarioDto> toDto(List<Horario> entityList);

    @Mappings({
            @Mapping(source = "diasHorario", target = "diasHorarioDto"),
            @Mapping(source = "idEstadoHorario", target = "idEstadoHorarioDto"),
            @Mapping(source = "horasHorario", target = "horasHorarioDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    Set<HorarioDto> toDto(Set<Horario> entityList);
}
