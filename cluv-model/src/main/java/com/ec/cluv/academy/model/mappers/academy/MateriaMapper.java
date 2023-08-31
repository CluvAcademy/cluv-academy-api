package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.entities.academy.Materia;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface MateriaMapper extends EntityMapper<MateriaDto, Materia> {

    @Mappings({
            @Mapping(source = "paqueteCollectionDto", target = "paqueteCollection"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection"),
            @Mapping(source = "silaboCollectionDto", target = "silaboCollection"),
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    Materia toEntity(MateriaDto dto);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "silaboCollection", target = "silaboCollectionDto"),
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    MateriaDto toDto(Materia entity);

    @Mappings({
            @Mapping(source = "paqueteCollectionDto", target = "paqueteCollection"),
            @Mapping(source = "claseCollectionDto", target = "claseCollection"),
            @Mapping(source = "silaboCollectionDto", target = "silaboCollection"),
            @Mapping(source = "idClubDto", target = "idClub")
    })
    @Override
    List<Materia> toEntity(List<MateriaDto> dtoList);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "silaboCollection", target = "silaboCollectionDto"),
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    List<MateriaDto> toDto(List<Materia> entityList);

    @Mappings({
            @Mapping(source = "paqueteCollection", target = "paqueteCollectionDto"),
            @Mapping(source = "claseCollection", target = "claseCollectionDto"),
            @Mapping(source = "silaboCollection", target = "silaboCollectionDto"),
            @Mapping(source = "idClub", target = "idClubDto")
    })
    @Override
    Set<MateriaDto> toDto(Set<Materia> entityList);
}
