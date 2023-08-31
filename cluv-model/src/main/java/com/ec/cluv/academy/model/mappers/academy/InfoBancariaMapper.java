package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.InfoBancariaDto;
import com.ec.cluv.academy.model.entities.academy.InfoBancaria;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface InfoBancariaMapper extends EntityMapper<InfoBancariaDto, InfoBancaria> {

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    InfoBancaria toEntity(InfoBancariaDto dto);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    InfoBancariaDto toDto(InfoBancaria entity);

    @Mappings({
            @Mapping(source = "idTutorDto", target = "idTutor")
    })
    @Override
    List<InfoBancaria> toEntity(List<InfoBancariaDto> dtoList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    List<InfoBancariaDto> toDto(List<InfoBancaria> entityList);

    @Mappings({
            @Mapping(source = "idTutor", target = "idTutorDto")
    })
    @Override
    Set<InfoBancariaDto> toDto(Set<InfoBancaria> entityList);
}
