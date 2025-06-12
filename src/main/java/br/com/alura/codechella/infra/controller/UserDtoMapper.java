package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.domain.entities.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserDtoMapper {
    
    UserEntity toEntity(UserDto dto);
    UserDto toDto(UserEntity domain);
    
}
