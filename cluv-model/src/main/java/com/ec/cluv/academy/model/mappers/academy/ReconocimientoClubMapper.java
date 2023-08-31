package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.ReconocimientoClubDto;
import com.ec.cluv.academy.model.entities.academy.ReconocimientoClub;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ReconocimientoClubMapper extends EntityMapper<ReconocimientoClubDto, ReconocimientoClub> {

    @Mappings({
            @Mapping(source = "clubCollectionDto", target = "clubCollection")
    })
    @Override
    ReconocimientoClub toEntity(ReconocimientoClubDto dto);

    @Mappings({
            @Mapping(source = "clubCollection", target = "clubCollectionDto")
    })
    @Override
    ReconocimientoClubDto toDto(ReconocimientoClub entity);

    @Mappings({
            @Mapping(source = "clubCollectionDto", target = "clubCollection")
    })
    @Override
    List<ReconocimientoClub> toEntity(List<ReconocimientoClubDto> dtoList);

    @Mappings({
            @Mapping(source = "clubCollection", target = "clubCollectionDto")
    })
    @Override
    List<ReconocimientoClubDto> toDto(List<ReconocimientoClub> entityList);

    @Mappings({
            @Mapping(source = "clubCollection", target = "clubCollectionDto")
    })
    @Override
    Set<ReconocimientoClubDto> toDto(Set<ReconocimientoClub> entityList);
}
