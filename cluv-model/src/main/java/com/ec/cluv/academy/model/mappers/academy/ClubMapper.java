package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.entities.academy.Club;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface ClubMapper extends EntityMapper<ClubDto, Club> {

    @Mappings({
            @Mapping(source = "foroClubCollectionDto", target = "foroClubCollection"),
            @Mapping(source = "idReconocimientoClubDto", target = "idReconocimientoClub"),
            @Mapping(source = "materiaCollectionDto", target = "materiaCollection"),
            @Mapping(source = "calificacionClubCollectionDto", target = "calificacionClubCollection")
    })
    @Override
    Club toEntity(ClubDto dto);

    @Mappings({
            @Mapping(source = "foroClubCollection", target = "foroClubCollectionDto"),
            @Mapping(source = "idReconocimientoClub", target = "idReconocimientoClubDto"),
            @Mapping(source = "materiaCollection", target = "materiaCollectionDto"),
            @Mapping(source = "calificacionClubCollection", target = "calificacionClubCollectionDto")
    })
    @Override
    ClubDto toDto(Club entity);

    @Mappings({
            @Mapping(source = "foroClubCollectionDto", target = "foroClubCollection"),
            @Mapping(source = "idReconocimientoClubDto", target = "idReconocimientoClub"),
            @Mapping(source = "materiaCollectionDto", target = "materiaCollection"),
            @Mapping(source = "calificacionClubCollectionDto", target = "calificacionClubCollection")
    })
    @Override
    List<Club> toEntity(List<ClubDto> dtoList);

    @Mappings({
            @Mapping(source = "foroClubCollection", target = "foroClubCollectionDto"),
            @Mapping(source = "idReconocimientoClub", target = "idReconocimientoClubDto"),
            @Mapping(source = "materiaCollection", target = "materiaCollectionDto"),
            @Mapping(source = "calificacionClubCollection", target = "calificacionClubCollectionDto")
    })
    @Override
    List<ClubDto> toDto(List<Club> entityList);

    @Mappings({
            @Mapping(source = "foroClubCollection", target = "foroClubCollectionDto"),
            @Mapping(source = "idReconocimientoClub", target = "idReconocimientoClubDto"),
            @Mapping(source = "materiaCollection", target = "materiaCollectionDto"),
            @Mapping(source = "calificacionClubCollection", target = "calificacionClubCollectionDto")
    })
    @Override
    Set<ClubDto> toDto(Set<Club> entityList);
}
