package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.PagosDto;
import com.ec.cluv.academy.model.dto.academy.TipoPagoDto;
import com.ec.cluv.academy.model.entities.academy.Pagos;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface PagosMapper extends EntityMapper<PagosDto, Pagos> {


    @Mappings({
            @Mapping(source = "idFacturaDto", target = "idFactura"),
            @Mapping(source = "idTipoPagoDto", target = "idTipoPago")
    })
    @Override
    Pagos toEntity(PagosDto dto);

    @Mappings({
            @Mapping(source = "idFactura", target = "idFacturaDto"),
            @Mapping(source = "idTipoPago", target = "idTipoPagoDto")
    })
    @Override
    PagosDto toDto(Pagos entity);

    @Mappings({
            @Mapping(source = "idFacturaDto", target = "idFactura"),
            @Mapping(source = "idTipoPagoDto", target = "idTipoPago")
    })
    @Override
    List<Pagos> toEntity(List<PagosDto> dtoList);

    @Mappings({
            @Mapping(source = "idFactura", target = "idFacturaDto"),
            @Mapping(source = "idTipoPago", target = "idTipoPagoDto")
    })
    @Override
    List<PagosDto> toDto(List<Pagos> entityList);

    @Mappings({
            @Mapping(source = "idFactura", target = "idFacturaDto"),
            @Mapping(source = "idTipoPago", target = "idTipoPagoDto")
    })
    @Override
    Set<PagosDto> toDto(Set<Pagos> entityList);
}
