package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.dto.academy.TutorDto;
import com.ec.cluv.academy.model.entities.academy.Tutor;
import com.ec.cluv.academy.model.entities.academy.Tutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface TutorMapper extends EntityMapper<TutorDto, Tutor> {

    @Mappings({
            @Mapping(source = "foroTutorCollectionDto", target = "foroTutorCollection"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection"),
            @Mapping(source = "multimediaTutorCollectionDto", target = "multimediaTutorCollection"),
            @Mapping(source = "infoBancariaCollectionDto", target = "infoBancariaCollection"),
            @Mapping(source = "horarioSugeridoTutorCollectionDto", target = "horarioSugeridoTutorCollection"),
            @Mapping(source = "infoAcademicaTutorCollectionDto", target = "infoAcademicaTutorCollection"),
            @Mapping(source = "idEstadoActividadTutorDto", target = "idEstadoActividadTutor"),
            @Mapping(source = "postulacionesCollectionDto", target = "postulacionesCollection"),
            @Mapping(source = "infoDestrezasCollectionDto", target = "infoDestrezasCollection"),
            @Mapping(source = "calificacionTutorCollectionDto", target = "calificacionTutorCollection")
    })
    @Override
    Tutor toEntity(TutorDto dto);

    @Mappings({
            @Mapping(source = "foroTutorCollection", target = "foroTutorCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "multimediaTutorCollection", target = "multimediaTutorCollectionDto"),
            @Mapping(source = "infoBancariaCollection", target = "infoBancariaCollectionDto"),
            @Mapping(source = "horarioSugeridoTutorCollection", target = "horarioSugeridoTutorCollectionDto"),
            @Mapping(source = "infoAcademicaTutorCollection", target = "infoAcademicaTutorCollectionDto"),
            @Mapping(source = "idEstadoActividadTutor", target = "idEstadoActividadTutorDto"),
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto"),
            @Mapping(source = "infoDestrezasCollection", target = "infoDestrezasCollectionDto"),
            @Mapping(source = "calificacionTutorCollection", target = "calificacionTutorCollectionDto")
    })
    @Override
    TutorDto toDto(Tutor entity);

    @Mappings({
            @Mapping(source = "foroTutorCollectionDto", target = "foroTutorCollection"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection"),
            @Mapping(source = "multimediaTutorCollectionDto", target = "multimediaTutorCollection"),
            @Mapping(source = "infoBancariaCollectionDto", target = "infoBancariaCollection"),
            @Mapping(source = "horarioSugeridoTutorCollectionDto", target = "horarioSugeridoTutorCollection"),
            @Mapping(source = "infoAcademicaTutorCollectionDto", target = "infoAcademicaTutorCollection"),
            @Mapping(source = "idEstadoActividadTutorDto", target = "idEstadoActividadTutor"),
            @Mapping(source = "postulacionesCollectionDto", target = "postulacionesCollection"),
            @Mapping(source = "infoDestrezasCollectionDto", target = "infoDestrezasCollection"),
            @Mapping(source = "calificacionTutorCollectionDto", target = "calificacionTutorCollection")
    })
    @Override
    List<Tutor> toEntity(List<TutorDto> dtoList);

    @Mappings({
            @Mapping(source = "foroTutorCollection", target = "foroTutorCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "multimediaTutorCollection", target = "multimediaTutorCollectionDto"),
            @Mapping(source = "infoBancariaCollection", target = "infoBancariaCollectionDto"),
            @Mapping(source = "horarioSugeridoTutorCollection", target = "horarioSugeridoTutorCollectionDto"),
            @Mapping(source = "infoAcademicaTutorCollection", target = "infoAcademicaTutorCollectionDto"),
            @Mapping(source = "idEstadoActividadTutor", target = "idEstadoActividadTutorDto"),
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto"),
            @Mapping(source = "infoDestrezasCollection", target = "infoDestrezasCollectionDto"),
            @Mapping(source = "calificacionTutorCollection", target = "calificacionTutorCollectionDto")
    })
    @Override
    List<TutorDto> toDto(List<Tutor> entityList);

    @Mappings({
            @Mapping(source = "foroTutorCollection", target = "foroTutorCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "multimediaTutorCollection", target = "multimediaTutorCollectionDto"),
            @Mapping(source = "infoBancariaCollection", target = "infoBancariaCollectionDto"),
            @Mapping(source = "horarioSugeridoTutorCollection", target = "horarioSugeridoTutorCollectionDto"),
            @Mapping(source = "infoAcademicaTutorCollection", target = "infoAcademicaTutorCollectionDto"),
            @Mapping(source = "idEstadoActividadTutor", target = "idEstadoActividadTutorDto"),
            @Mapping(source = "postulacionesCollection", target = "postulacionesCollectionDto"),
            @Mapping(source = "infoDestrezasCollection", target = "infoDestrezasCollectionDto"),
            @Mapping(source = "calificacionTutorCollection", target = "calificacionTutorCollectionDto")
    })
    @Override
    Set<TutorDto> toDto(Set<Tutor> entityList);
}
