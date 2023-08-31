package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.TipoPagoDto;
import com.ec.cluv.academy.model.entities.academy.TipoPago;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface TipoPagoMapper extends EntityMapper<TipoPagoDto, TipoPago> {

    @Mappings({
            @Mapping(source = "pagosCollectionDto", target = "pagosCollection")
    })
    @Override
    TipoPago toEntity(TipoPagoDto dto);

    @Mappings({
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto")
    })
    @Override
    TipoPagoDto toDto(TipoPago entity);

    @Mappings({
            @Mapping(source = "pagosCollectionDto", target = "pagosCollection")
    })
    @Override
    List<TipoPago> toEntity(List<TipoPagoDto> dtoList);

    @Mappings({
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto")
    })
    @Override
    List<TipoPagoDto> toDto(List<TipoPago> entityList);

    @Mappings({
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto")
    })
    @Override
    Set<TipoPagoDto> toDto(Set<TipoPago> entityList);
}
