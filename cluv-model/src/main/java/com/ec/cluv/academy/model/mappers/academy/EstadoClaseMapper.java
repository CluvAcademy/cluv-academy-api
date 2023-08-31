package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoClaseDto;
import com.ec.cluv.academy.model.entities.academy.EstadoClase;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoClaseMapper extends EntityMapper<EstadoClaseDto, EstadoClase> {
    

    @Mappings({
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    EstadoClase toEntity(EstadoClaseDto dto);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    EstadoClaseDto toDto(EstadoClase entity);

    @Mappings({
            @Mapping(source = "claseCollectionDto", target = "claseCollection")
    })
    @Override
    List<EstadoClase> toEntity(List<EstadoClaseDto> dtoList);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    List<EstadoClaseDto> toDto(List<EstadoClase> entityList);

    @Mappings({
            @Mapping(source = "claseCollection", target = "claseCollectionDto")
    })
    @Override
    Set<EstadoClaseDto> toDto(Set<EstadoClase> entityList);
}
