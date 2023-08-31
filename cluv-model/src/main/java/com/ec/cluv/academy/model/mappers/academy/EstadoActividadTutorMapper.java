package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoActividadTutorDto;
import com.ec.cluv.academy.model.entities.academy.EstadoActividadTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoActividadTutorMapper extends EntityMapper<EstadoActividadTutorDto, EstadoActividadTutor> {

    @Mappings({
            @Mapping(source = "tutorCollectionDto", target = "tutorCollection")
    })
    @Override
    EstadoActividadTutor toEntity(EstadoActividadTutorDto dto);

    @Mappings({
            @Mapping(source = "tutorCollection", target = "tutorCollectionDto")
    })
    @Override
    EstadoActividadTutorDto toDto(EstadoActividadTutor entity);

    @Mappings({
            @Mapping(source = "tutorCollectionDto", target = "tutorCollection")
    })
    @Override
    List<EstadoActividadTutor> toEntity(List<EstadoActividadTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "tutorCollection", target = "tutorCollectionDto")
    })
    @Override
    List<EstadoActividadTutorDto> toDto(List<EstadoActividadTutor> entityList);

    @Mappings({
            @Mapping(source = "tutorCollection", target = "tutorCollectionDto")
    })
    @Override
    Set<EstadoActividadTutorDto> toDto(Set<EstadoActividadTutor> entityList);
}
