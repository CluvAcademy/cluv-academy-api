package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.TipoPaqueteDto;
import com.ec.cluv.academy.model.entities.academy.TipoPaquete;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface TipoPaqueteMapper extends EntityMapper<TipoPaqueteDto, TipoPaquete> {


    @Mappings({
            @Mapping(source = "paqueteCollectionDto", target = "paqueteCollection")
    })
    @Override
    TipoPaquete toEntity(TipoPaqueteDto dto);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto")
    })
    @Override
    TipoPaqueteDto toDto(TipoPaquete entity);

    @Mappings({
            @Mapping(source = "paqueteCollectionDto", target = "paqueteCollection")
    })
    @Override
    List<TipoPaquete> toEntity(List<TipoPaqueteDto> dtoList);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto")
    })
    @Override
    List<TipoPaqueteDto> toDto(List<TipoPaquete> entityList);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto")
    })
    @Override
    Set<TipoPaqueteDto> toDto(Set<TipoPaquete> entityList);
}
