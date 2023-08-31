package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.SilaboDto;
import com.ec.cluv.academy.model.entities.academy.Silabo;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface SilaboMapper extends EntityMapper<SilaboDto, Silabo> {


    @Mappings({
            @Mapping(source = "idMateriaDto", target = "idMateria")
    })
    @Override
    Silabo toEntity(SilaboDto dto);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto")
    })
    @Override
    SilaboDto toDto(Silabo entity);

    @Mappings({
            @Mapping(source = "idMateriaDto", target = "idMateria")
    })
    @Override
    List<Silabo> toEntity(List<SilaboDto> dtoList);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto")
    })
    @Override
    List<SilaboDto> toDto(List<Silabo> entityList);

    @Mappings({
            @Mapping(source = "idMateria", target = "idMateriaDto")
    })
    @Override
    Set<SilaboDto> toDto(Set<Silabo> entityList);
}
