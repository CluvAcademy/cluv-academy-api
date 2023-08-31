package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ForoTutorDto;
import com.ec.cluv.academy.model.entities.academy.ForoTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ForoTutorMapper extends EntityMapper<ForoTutorDto, ForoTutor> {
    

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    ForoTutor toEntity(ForoTutorDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    ForoTutorDto toDto(ForoTutor entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<ForoTutor> toEntity(List<ForoTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<ForoTutorDto> toDto(List<ForoTutor> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<ForoTutorDto> toDto(Set<ForoTutor> entityList);
}
