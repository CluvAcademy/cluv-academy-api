package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.MenuDto;
import com.ec.cluv.academy.model.entities.publick.Menu;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDto, Menu> {


    @Override
    Menu toEntity(MenuDto dto);


    @Override
    MenuDto toDto(Menu entity);


    @Override
    List<Menu> toEntity(List<MenuDto> dtoList);


    @Override
    List<MenuDto> toDto(List<Menu> entityList);


    @Override
    Set<MenuDto> toDto(Set<Menu> entityList);
}
