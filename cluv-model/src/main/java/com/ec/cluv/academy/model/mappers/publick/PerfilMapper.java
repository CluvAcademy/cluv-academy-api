package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.PerfilDto;
import com.ec.cluv.academy.model.entities.publick.Perfil;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface PerfilMapper extends EntityMapper<PerfilDto, Perfil> {

    @Mappings({
            @Mapping(source = "autorizacionListDto", target = "autorizacionList"),
            @Mapping(source = "perfilUsuarioListDto", target = "perfilUsuarioList")
    })
    @Override
    Perfil toEntity(PerfilDto dto);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDto"),
            @Mapping(source = "perfilUsuarioList", target = "perfilUsuarioListDto")
    })
    @Override
    PerfilDto toDto(Perfil entity);

    @Mappings({
            @Mapping(source = "autorizacionListDto", target = "autorizacionList"),
            @Mapping(source = "perfilUsuarioListDto", target = "perfilUsuarioList")
    })
    @Override
    List<Perfil> toEntity(List<PerfilDto> dtoList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDto"),
            @Mapping(source = "perfilUsuarioList", target = "perfilUsuarioListDto")
    })
    @Override
    List<PerfilDto> toDto(List<Perfil> entityList);

    @Mappings({
            @Mapping(source = "autorizacionList", target = "autorizacionListDto"),
            @Mapping(source = "perfilUsuarioList", target = "perfilUsuarioListDto")
    })
    @Override
    Set<PerfilDto> toDto(Set<Perfil> entityList);
}
