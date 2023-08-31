package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ReseniasDto;
import com.ec.cluv.academy.model.entities.academy.Resenias;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ReseniasMapper extends EntityMapper<ReseniasDto, Resenias> {


    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    Resenias toEntity(ReseniasDto dto);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    ReseniasDto toDto(Resenias entity);

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    List<Resenias> toEntity(List<ReseniasDto> dtoList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    List<ReseniasDto> toDto(List<Resenias> entityList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    Set<ReseniasDto> toDto(Set<Resenias> entityList);
}
