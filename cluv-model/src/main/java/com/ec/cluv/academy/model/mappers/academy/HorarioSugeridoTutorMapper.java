package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.HorarioSugeridoTutorDto;
import com.ec.cluv.academy.model.entities.academy.HorarioSugeridoTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface HorarioSugeridoTutorMapper extends EntityMapper<HorarioSugeridoTutorDto, HorarioSugeridoTutor> {
    

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    HorarioSugeridoTutor toEntity(HorarioSugeridoTutorDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    HorarioSugeridoTutorDto toDto(HorarioSugeridoTutor entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<HorarioSugeridoTutor> toEntity(List<HorarioSugeridoTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<HorarioSugeridoTutorDto> toDto(List<HorarioSugeridoTutor> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<HorarioSugeridoTutorDto> toDto(Set<HorarioSugeridoTutor> entityList);
}
