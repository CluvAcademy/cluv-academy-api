package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ForoClaseDto;
import com.ec.cluv.academy.model.entities.academy.ForoClase;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ForoClaseMapper extends EntityMapper<ForoClaseDto, ForoClase> {

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    ForoClase toEntity(ForoClaseDto dto);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    ForoClaseDto toDto(ForoClase entity);

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    List<ForoClase> toEntity(List<ForoClaseDto> dtoList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    List<ForoClaseDto> toDto(List<ForoClase> entityList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    Set<ForoClaseDto> toDto(Set<ForoClase> entityList);
}
