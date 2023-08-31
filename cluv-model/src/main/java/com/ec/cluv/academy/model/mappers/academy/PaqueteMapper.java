package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.PaqueteDto;
import com.ec.cluv.academy.model.dto.academy.TipoPaqueteDto;
import com.ec.cluv.academy.model.entities.academy.Paquete;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface PaqueteMapper extends EntityMapper<PaqueteDto, Paquete> {

    @Mappings({
            @Mapping(source = "idMateriaDto", target = "idMateria"),
            @Mapping(source = "idTipoPaqueteDto", target = "idTipoPaquete")
    })
    @Override
    Paquete toEntity(PaqueteDto dto);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoPaquete", target = "idTipoPaqueteDto")
    })
    @Override
    PaqueteDto toDto(Paquete entity);

    @Mappings({
            @Mapping(source = "idMateriaDto", target = "idMateria"),
            @Mapping(source = "idTipoPaqueteDto", target = "idTipoPaquete")
    })
    @Override
    List<Paquete> toEntity(List<PaqueteDto> dtoList);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoPaquete", target = "idTipoPaqueteDto")
    })
    @Override
    List<PaqueteDto> toDto(List<Paquete> entityList);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoPaquete", target = "idTipoPaqueteDto")
    })
    @Override
    Set<PaqueteDto> toDto(Set<Paquete> entityList);
}
