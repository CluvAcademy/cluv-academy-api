package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.InfoDestrezasDto;
import com.ec.cluv.academy.model.entities.academy.InfoDestrezas;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface InfoDestrezasMapper extends EntityMapper<InfoDestrezasDto, InfoDestrezas> {
    

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    InfoDestrezas toEntity(InfoDestrezasDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    InfoDestrezasDto toDto(InfoDestrezas entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<InfoDestrezas> toEntity(List<InfoDestrezasDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<InfoDestrezasDto> toDto(List<InfoDestrezas> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<InfoDestrezasDto> toDto(Set<InfoDestrezas> entityList);
}
