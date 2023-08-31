package com.ec.cluv.academy.model.mappers.academy;


import com.ec.cluv.academy.model.dto.academy.*;
import com.ec.cluv.academy.model.entities.academy.CarritoCompras;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface CarritoComprasMapper extends EntityMapper<CarritoComprasDto, CarritoCompras> {

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase"),
            @Mapping(source = "idEstadoCarritoComprasDto", target = "idEstadoCarritoCompras"),
            @Mapping(source = "idEstudianteDto", target = "idEstudiante"),
            @Mapping(source = "idFacturaDto", target = "idFactura")
    })
    @Override
    CarritoCompras toEntity(CarritoComprasDto dto);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto"),
            @Mapping(source = "idEstadoCarritoCompras", target = "idEstadoCarritoComprasDto"),
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idFactura", target = "idFacturaDto")
    })
    @Override
    CarritoComprasDto toDto(CarritoCompras entity);

    @Mappings({
            @Mapping(source = "idClaseDto", target = "idClase"),
            @Mapping(source = "idEstadoCarritoComprasDto", target = "idEstadoCarritoCompras"),
            @Mapping(source = "idEstudianteDto", target = "idEstudiante"),
            @Mapping(source = "idFacturaDto", target = "idFactura")
    })
    @Override
    List<CarritoCompras> toEntity(List<CarritoComprasDto> dtoList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto"),
            @Mapping(source = "idEstadoCarritoCompras", target = "idEstadoCarritoComprasDto"),
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idFactura", target = "idFacturaDto")
    })
    @Override
    List<CarritoComprasDto> toDto(List<CarritoCompras> entityList);

    @Mappings({
            @Mapping(source = "idClase", target = "idClaseDto"),
            @Mapping(source = "idEstadoCarritoCompras", target = "idEstadoCarritoComprasDto"),
            @Mapping(source = "idEstudiante", target = "idEstudianteDto"),
            @Mapping(source = "idFactura", target = "idFacturaDto")
    })
    @Override
    Set<CarritoComprasDto> toDto(Set<CarritoCompras> entityList);
}
