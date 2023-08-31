package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.HorasHorarioDto;
import com.ec.cluv.academy.model.entities.academy.HorasHorario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface HorasHorarioMapper extends EntityMapper<HorasHorarioDto, HorasHorario> {


    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    HorasHorario toEntity(HorasHorarioDto dto);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    HorasHorarioDto toDto(HorasHorario entity);

    @Mappings({
            @Mapping(source = "horarioCollectionDto", target = "horarioCollection")
    })
    @Override
    List<HorasHorario> toEntity(List<HorasHorarioDto> dtoList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    List<HorasHorarioDto> toDto(List<HorasHorario> entityList);

    @Mappings({
            @Mapping(source = "horarioCollection", target = "horarioCollectionDto")
    })
    @Override
    Set<HorasHorarioDto> toDto(Set<HorasHorario> entityList);
}
