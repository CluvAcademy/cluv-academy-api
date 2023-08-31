package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.TiposLogrosDto;
import com.ec.cluv.academy.model.entities.academy.TiposLogros;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface TiposLogrosMapper extends EntityMapper<TiposLogrosDto, TiposLogros> {


    @Mappings({
            @Mapping(source = "logrosCollectionDto", target = "logrosCollection")
    })
    @Override
    TiposLogros toEntity(TiposLogrosDto dto);

    @Mappings({
            @Mapping(source = "logrosCollection", target = "logrosCollectionDto")
    })
    @Override
    TiposLogrosDto toDto(TiposLogros entity);

    @Mappings({
            @Mapping(source = "logrosCollectionDto", target = "logrosCollection")
    })
    @Override
    List<TiposLogros> toEntity(List<TiposLogrosDto> dtoList);

    @Mappings({
            @Mapping(source = "logrosCollection", target = "logrosCollectionDto")
    })
    @Override
    List<TiposLogrosDto> toDto(List<TiposLogros> entityList);

    @Mappings({
            @Mapping(source = "logrosCollection", target = "logrosCollectionDto")
    })
    @Override
    Set<TiposLogrosDto> toDto(Set<TiposLogros> entityList);
}
