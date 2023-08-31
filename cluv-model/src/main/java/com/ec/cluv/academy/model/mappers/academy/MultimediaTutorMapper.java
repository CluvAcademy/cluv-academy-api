package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.MultimediaTutorDto;
import com.ec.cluv.academy.model.entities.academy.MultimediaTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface MultimediaTutorMapper extends EntityMapper<MultimediaTutorDto, MultimediaTutor> {

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    MultimediaTutor toEntity(MultimediaTutorDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    MultimediaTutorDto toDto(MultimediaTutor entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<MultimediaTutor> toEntity(List<MultimediaTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<MultimediaTutorDto> toDto(List<MultimediaTutor> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<MultimediaTutorDto> toDto(Set<MultimediaTutor> entityList);
}
