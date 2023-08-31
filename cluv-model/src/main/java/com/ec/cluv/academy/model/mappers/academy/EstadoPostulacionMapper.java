package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoPostulacionDto;
import com.ec.cluv.academy.model.entities.academy.EstadoPostulacion;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoPostulacionMapper extends EntityMapper<EstadoPostulacionDto, EstadoPostulacion> {
    

    @Mappings({
            @Mapping(source = "postulacionesCollectionDto", target = "postulacionesCollection")
    })
    @Override
    EstadoPostulacion toEntity(EstadoPostulacionDto dto);

    @Mappings({
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto")
    })
    @Override
    EstadoPostulacionDto toDto(EstadoPostulacion entity);

    @Mappings({
            @Mapping(source = "postulacionesCollectionDto", target = "postulacionesCollection")
    })
    @Override
    List<EstadoPostulacion> toEntity(List<EstadoPostulacionDto> dtoList);

    @Mappings({
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto")
    })
    @Override
    List<EstadoPostulacionDto> toDto(List<EstadoPostulacion> entityList);

    @Mappings({
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto")
    })
    @Override
    Set<EstadoPostulacionDto> toDto(Set<EstadoPostulacion> entityList);
}
