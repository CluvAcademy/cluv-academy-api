package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.PostulacionesDto;
import com.ec.cluv.academy.model.dto.academy.TutorDto;
import com.ec.cluv.academy.model.entities.academy.Postulaciones;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface PostulacionesMapper extends EntityMapper<PostulacionesDto, Postulaciones> {


    @Mappings({
            @Mapping(source = "idEstadoPostulacionDto", target = "idEstadoPostulacion"),
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    Postulaciones toEntity(PostulacionesDto dto);

    @Mappings({
            @Mapping(source = "idEstadoPostulacion", target = "idEstadoPostulacionDto"),
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    PostulacionesDto toDto(Postulaciones entity);

    @Mappings({
            @Mapping(source = "idEstadoPostulacionDto", target = "idEstadoPostulacion"),
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<Postulaciones> toEntity(List<PostulacionesDto> dtoList);

    @Mappings({
            @Mapping(source = "idEstadoPostulacion", target = "idEstadoPostulacionDto"),
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<PostulacionesDto> toDto(List<Postulaciones> entityList);

    @Mappings({
            @Mapping(source = "idEstadoPostulacion", target = "idEstadoPostulacionDto"),
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<PostulacionesDto> toDto(Set<Postulaciones> entityList);
}
