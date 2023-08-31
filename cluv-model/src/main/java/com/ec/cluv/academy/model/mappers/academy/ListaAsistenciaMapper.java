package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ListaAsistenciaDto;
import com.ec.cluv.academy.model.entities.academy.ListaAsistencia;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ListaAsistenciaMapper extends EntityMapper<ListaAsistenciaDto, ListaAsistencia> {
    

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    ListaAsistencia toEntity(ListaAsistenciaDto dto);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    ListaAsistenciaDto toDto(ListaAsistencia entity);

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase")
    })
    @Override
    List<ListaAsistencia> toEntity(List<ListaAsistenciaDto> dtoList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    List<ListaAsistenciaDto> toDto(List<ListaAsistencia> entityList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto")
    })
    @Override
    Set<ListaAsistenciaDto> toDto(Set<ListaAsistencia> entityList);
}
