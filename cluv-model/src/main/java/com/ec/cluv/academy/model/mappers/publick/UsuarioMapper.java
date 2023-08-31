package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.UsuarioDto;
import com.ec.cluv.academy.model.entities.publick.Usuario;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toEntity(UsuarioDto dto);
    UsuarioDto toDto(Usuario entity);
    List<Usuario> toEntity(List<UsuarioDto> dtoList);
    List<UsuarioDto> toDto(List<Usuario> entityList);
    Set<UsuarioDto> toDto(Set<Usuario> entityList);
}
