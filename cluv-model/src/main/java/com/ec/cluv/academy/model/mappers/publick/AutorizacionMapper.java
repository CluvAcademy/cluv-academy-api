package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.AutorizacionDto;
import com.ec.cluv.academy.model.entities.publick.Autorizacion;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface AutorizacionMapper extends EntityMapper<AutorizacionDto, Autorizacion> {

    @Mappings({
            @Mapping(source = "idMenuDto", target = "idMenu"),
            @Mapping(source = "idPerfilDto", target = "idPerfil")
    })
    @Override
    Autorizacion toEntity(AutorizacionDto dto);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDto"),
            @Mapping(source = "idPerfil", target = "idPerfilDto")
    })
    @Override
    AutorizacionDto toDto(Autorizacion entity);

    @Mappings({
            @Mapping(source = "idMenuDto", target = "idMenu"),
            @Mapping(source = "idPerfilDto", target = "idPerfil")
    })
    @Override
    List<Autorizacion> toEntity(List<AutorizacionDto> dtoList);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDto"),
            @Mapping(source = "idPerfil", target = "idPerfilDto")
    })
    @Override
    List<AutorizacionDto> toDto(List<Autorizacion> entityList);

    @Mappings({
            @Mapping(source = "idMenu", target = "idMenuDto"),
            @Mapping(source = "idPerfil", target = "idPerfilDto")
    })
    @Override
    Set<AutorizacionDto> toDto(Set<Autorizacion> entityList);
}
