package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.TipoClaseDto;
import com.ec.cluv.academy.model.entities.academy.TipoClase;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface TipoClaseMapper extends EntityMapper<TipoClaseDto, TipoClase> {


    @Mappings({
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    TipoClase toEntity(TipoClaseDto dto);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    TipoClaseDto toDto(TipoClase entity);

    @Mappings({
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    List<TipoClase> toEntity(List<TipoClaseDto> dtoList);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    List<TipoClaseDto> toDto(List<TipoClase> entityList);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    Set<TipoClaseDto> toDto(Set<TipoClase> entityList);
}
