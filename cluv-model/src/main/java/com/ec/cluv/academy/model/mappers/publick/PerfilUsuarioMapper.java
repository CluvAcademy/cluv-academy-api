package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.PerfilUsuarioDto;
import com.ec.cluv.academy.model.entities.publick.PerfilUsuario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface PerfilUsuarioMapper extends EntityMapper<PerfilUsuarioDto, PerfilUsuario> {

    @Mappings({
            @Mapping(source = "perfilDto", target = "perfil"),
            @Mapping(source = "usuarioDto", target = "usuario")
    })
    @Override
    PerfilUsuario toEntity(PerfilUsuarioDto dto);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDto"),
            @Mapping(source = "usuario", target = "usuarioDto")
    })
    @Override
    PerfilUsuarioDto toDto(PerfilUsuario entity);

    @Mappings({
            @Mapping(source = "perfilDto", target = "perfil"),
            @Mapping(source = "usuarioDto", target = "usuario")
    })
    @Override
    List<PerfilUsuario> toEntity(List<PerfilUsuarioDto> dtoList);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDto"),
            @Mapping(source = "usuario", target = "usuarioDto")
    })
    @Override
    List<PerfilUsuarioDto> toDto(List<PerfilUsuario> entityList);

    @Mappings({
            @Mapping(source = "perfil", target = "perfilDto"),
            @Mapping(source = "usuario", target = "usuarioDto")
    })
    @Override
    Set<PerfilUsuarioDto> toDto(Set<PerfilUsuario> entityList);
}
