package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.entities.academy.Clase;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ClaseMapper extends EntityMapper<ClaseDto, Clase> {

    @Mappings({
            @Mapping(source = "idEstadoClaseDto", target = "idEstadoClase"),
            @Mapping(source = "horarioDto", target = "horario"),
            @Mapping(source = "idMateriaDto", target = "idMateria"),
            @Mapping(source = "idTipoClaseDto", target = "idTipoClase"),
            @Mapping(source = "idTutorDto", target = "idTutor"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection"),
            @Mapping(source = "listaAsistenciaCollectionDto", target = "listaAsistenciaCollection"),
            @Mapping(source = "reseniasCollectionDto", target = "reseniasCollection"),
            @Mapping(source = "foroClaseCollectionDto", target = "foroClaseCollection")
    })
    @Override
    Clase toEntity(ClaseDto dto);

    @Mappings({
            @Mapping(source = "idEstadoClase", target = "idEstadoClaseDto"),
            @Mapping(source = "horario", target = "horarioDto"),
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoClase", target = "idTipoClaseDto"),
            @Mapping(source = "idTutor", target = "idTutorDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto"),
            @Mapping(source = "listaAsistenciaCollection", target = "listaAsistenciaCollectionDto"),
            @Mapping(source = "reseniasCollection", target = "reseniasCollectionDto"),
            @Mapping(source = "foroClaseCollection", target = "foroClaseCollectionDto")
    })
    @Override
    ClaseDto toDto(Clase entity);


    @Mappings({
            @Mapping(source = "idEstadoClaseDto", target = "idEstadoClase"),
            @Mapping(source = "horarioDto", target = "horario"),
            @Mapping(source = "idMateriaDto", target = "idMateria"),
            @Mapping(source = "idTipoClaseDto", target = "idTipoClase"),
            @Mapping(source = "idTutorDto", target = "idTutor"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection"),
            @Mapping(source = "listaAsistenciaCollectionDto", target = "listaAsistenciaCollection"),
            @Mapping(source = "reseniasCollectionDto", target = "reseniasCollection"),
            @Mapping(source = "foroClaseCollectionDto", target = "foroClaseCollection")
    })
    @Override
    List<Clase> toEntity(List<ClaseDto> dtoList);

    @Mappings({
            @Mapping(source = "idEstadoClase", target = "idEstadoClaseDto"),
            @Mapping(source = "horario", target = "horarioDto"),
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoClase", target = "idTipoClaseDto"),
            @Mapping(source = "idTutor", target = "idTutorDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto"),
            @Mapping(source = "listaAsistenciaCollection", target = "listaAsistenciaCollectionDto"),
            @Mapping(source = "reseniasCollection", target = "reseniasCollectionDto"),
            @Mapping(source = "foroClaseCollection", target = "foroClaseCollectionDto")
    })
    @Override
    List<ClaseDto> toDto(List<Clase> entityList);

    @Mappings({
            @Mapping(source = "idEstadoClase", target = "idEstadoClaseDto"),
            @Mapping(source = "horario", target = "horarioDto"),
            @Mapping(source = "idMateria", target = "idMateriaDto"),
            @Mapping(source = "idTipoClase", target = "idTipoClaseDto"),
            @Mapping(source = "idTutor", target = "idTutorDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto"),
            @Mapping(source = "listaAsistenciaCollection", target = "listaAsistenciaCollectionDto"),
            @Mapping(source = "reseniasCollection", target = "reseniasCollectionDto"),
            @Mapping(source = "foroClaseCollection", target = "foroClaseCollectionDto")
    })
    @Override
    Set<ClaseDto> toDto(Set<Clase> entityList);
}
