package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.InfoAcademicaTutorDto;
import com.ec.cluv.academy.model.entities.academy.InfoAcademicaTutor;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface InfoAcademicaTutorMapper extends EntityMapper<InfoAcademicaTutorDto, InfoAcademicaTutor> {

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    InfoAcademicaTutor toEntity(InfoAcademicaTutorDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    InfoAcademicaTutorDto toDto(InfoAcademicaTutor entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<InfoAcademicaTutor> toEntity(List<InfoAcademicaTutorDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<InfoAcademicaTutorDto> toDto(List<InfoAcademicaTutor> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<InfoAcademicaTutorDto> toDto(Set<InfoAcademicaTutor> entityList);
}
