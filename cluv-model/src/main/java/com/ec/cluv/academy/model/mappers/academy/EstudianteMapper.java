package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.CarritoComprasDto;
import com.ec.cluv.academy.model.dto.academy.EstadoEstudianteDto;
import com.ec.cluv.academy.model.dto.academy.EstudianteDto;
import com.ec.cluv.academy.model.dto.publick.AplicacionDto;
import com.ec.cluv.academy.model.entities.academy.Estudiante;
import com.ec.cluv.academy.model.entities.publick.Aplicacion;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstudianteMapper extends EntityMapper<EstudianteDto, Estudiante> {

    @Mappings({
            @Mapping(source = "idEstadoEstudianteDto", target = "idEstadoEstudiante"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override
    Estudiante toEntity(EstudianteDto dto);

    @Mappings({
            @Mapping(source = "idEstadoEstudiante", target = "idEstadoEstudianteDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    EstudianteDto toDto(Estudiante entity);

    @Mappings({
            @Mapping(source = "idEstadoEstudianteDto", target = "idEstadoEstudiante"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override

    List<Estudiante> toEntity(List<EstudianteDto> dtoList);

    @Mappings({
            @Mapping(source = "idEstadoEstudiante", target = "idEstadoEstudianteDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    List<EstudianteDto> toDto(List<Estudiante> entityList);

    @Mappings({
            @Mapping(source = "idEstadoEstudiante", target = "idEstadoEstudianteDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    Set<EstudianteDto> toDto(Set<Estudiante> entityList);
}
