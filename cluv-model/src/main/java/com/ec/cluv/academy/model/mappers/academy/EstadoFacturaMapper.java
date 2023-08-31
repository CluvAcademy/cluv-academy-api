package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoFacturaDto;
import com.ec.cluv.academy.model.entities.academy.EstadoFactura;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoFacturaMapper extends EntityMapper<EstadoFacturaDto, EstadoFactura> {

    @Mappings({
            @Mapping(source = "facturaCollectionDto", target = "facturaCollection")
    })
    @Override
    EstadoFactura toEntity(EstadoFacturaDto dto);

    @Mappings({
            @Mapping(source = "facturaCollection", target = "facturaCollectionDto")
    })
    @Override
    EstadoFacturaDto toDto(EstadoFactura entity);

    @Mappings({
            @Mapping(source = "facturaCollectionDto", target = "facturaCollection")
    })
    @Override
    List<EstadoFactura> toEntity(List<EstadoFacturaDto> dtoList);

    @Mappings({
            @Mapping(source = "facturaCollection", target = "facturaCollectionDto")
    })
    @Override
    List<EstadoFacturaDto> toDto(List<EstadoFactura> entityList);

    @Mappings({
            @Mapping(source = "facturaCollection", target = "facturaCollectionDto")
    })
    @Override
    Set<EstadoFacturaDto> toDto(Set<EstadoFactura> entityList);
}
