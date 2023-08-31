package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ForoClubDto;
import com.ec.cluv.academy.model.entities.academy.ForoClub;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ForoClubMapper extends EntityMapper<ForoClubDto, ForoClub> {

    @Mappings({
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    ForoClub toEntity(ForoClubDto dto);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    ForoClubDto toDto(ForoClub entity);

    @Mappings({
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    List<ForoClub> toEntity(List<ForoClubDto> dtoList);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    List<ForoClubDto> toDto(List<ForoClub> entityList);

    @Mappings({
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    Set<ForoClubDto> toDto(Set<ForoClub> entityList);
}
