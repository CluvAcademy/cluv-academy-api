package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.AplicacionDto;
import com.ec.cluv.academy.model.entities.publick.Aplicacion;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface AplicacionMapper extends EntityMapper<AplicacionDto, Aplicacion> {

    @Mapping(source = "menuListDto", target = "menuList")
    @Override
    Aplicacion toEntity(AplicacionDto dto);

    @Mapping(source = "menuList", target = "menuListDto")
    @Override
    AplicacionDto toDto(Aplicacion entity);

    @Mapping(source = "menuListDto", target = "menuList")
    @Override
    List<Aplicacion> toEntity(List<AplicacionDto> dtoList);

    @Mapping(source = "menuList", target = "menuListDto")
    @Override
    List<AplicacionDto> toDto(List<Aplicacion> entityList);

    @Mapping(source = "menuList", target = "menuListDto")
    @Override
    Set<AplicacionDto> toDto(Set<Aplicacion> entityList);
}
