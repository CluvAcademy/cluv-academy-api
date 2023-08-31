package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.CarritoComprasDto;
import com.ec.cluv.academy.model.dto.academy.EstadoFacturaDto;
import com.ec.cluv.academy.model.dto.academy.FacturaDto;
import com.ec.cluv.academy.model.dto.academy.PagosDto;
import com.ec.cluv.academy.model.entities.academy.Factura;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface FacturaMapper extends EntityMapper<FacturaDto, Factura> {

    @Mappings({
            @Mapping(source = "idEstadoFacturaDto", target = "idEstadoFactura"),
            @Mapping(source = "pagosCollectionDto", target = "pagosCollection"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override
    Factura toEntity(FacturaDto dto);

    @Mappings({
            @Mapping(source = "idEstadoFactura", target = "idEstadoFacturaDto"),
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    FacturaDto toDto(Factura entity);

    @Mappings({
            @Mapping(source = "idEstadoFacturaDto", target = "idEstadoFactura"),
            @Mapping(source = "pagosCollectionDto", target = "pagosCollection"),
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override
    List<Factura> toEntity(List<FacturaDto> dtoList);

    @Mappings({
            @Mapping(source = "idEstadoFactura", target = "idEstadoFacturaDto"),
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    List<FacturaDto> toDto(List<Factura> entityList);

    @Mappings({
            @Mapping(source = "idEstadoFactura", target = "idEstadoFacturaDto"),
            @Mapping(source = "pagosCollection", target = "pagosCollectionDto"),
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    Set<FacturaDto> toDto(Set<Factura> entityList);
}
