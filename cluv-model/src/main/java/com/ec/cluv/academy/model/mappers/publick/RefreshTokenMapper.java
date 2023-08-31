package com.ec.cluv.academy.model.mappers.publick;

import com.ec.cluv.academy.model.dto.publick.RefreshTokenDto;
import com.ec.cluv.academy.model.entities.publick.RefreshToken;
import com.ec.cluv.academy.model.mappers.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper extends EntityMapper<RefreshTokenDto, RefreshToken> {
    @Mapping(source = "userDto", target = "user")
    @Override
    RefreshToken toEntity(RefreshTokenDto dto);

    @Mapping(source = "user", target = "userDto")
    @Override
    RefreshTokenDto toDto(RefreshToken entity);

    @Mapping(source = "userDto", target = "user")
    @Override
    List<RefreshToken> toEntity(List<RefreshTokenDto> dtoList);

    @Mapping(source = "user", target = "userDto")
    @Override
    List<RefreshTokenDto> toDto(List<RefreshToken> entityList);

    @Mapping(source = "user", target = "userDto")
    @Override
    Set<RefreshTokenDto> toDto(Set<RefreshToken> entityList);
}
