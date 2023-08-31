package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.EstadoCarritoComprasDto;
import com.ec.cluv.academy.model.entities.academy.EstadoCarritoCompras;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface EstadoCarritoComprasMapper extends EntityMapper<EstadoCarritoComprasDto, EstadoCarritoCompras> {
    

    @Mappings({
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override
    EstadoCarritoCompras toEntity(EstadoCarritoComprasDto dto);

    @Mappings({
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    EstadoCarritoComprasDto toDto(EstadoCarritoCompras entity);

    @Mappings({
            @Mapping(source = "carritoComprasCollectionDto", target = "carritoComprasCollection")
    })
    @Override
    List<EstadoCarritoCompras> toEntity(List<EstadoCarritoComprasDto> dtoList);

    @Mappings({
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    List<EstadoCarritoComprasDto> toDto(List<EstadoCarritoCompras> entityList);

    @Mappings({
            @Mapping(source = "carritoComprasCollection", target = "carritoComprasCollectionDto")
    })
    @Override
    Set<EstadoCarritoComprasDto> toDto(Set<EstadoCarritoCompras> entityList);
}
