package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.domain.entities.user.UserEntity;
import br.com.alura.codechella.infra.jpa.model.UserModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserModelMapper {
    
    UserModel toModel(UserEntity userEntity);

    UserEntity toEntity(UserModel userModel);
}
