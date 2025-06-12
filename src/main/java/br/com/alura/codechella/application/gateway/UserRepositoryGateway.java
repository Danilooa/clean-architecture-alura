package br.com.alura.codechella.application.gateway;

import br.com.alura.codechella.domain.entities.user.UserEntity;

import java.util.List;

public interface UserRepositoryGateway {

    UserEntity create(UserEntity userEntity);
    
    UserEntity update(String cpf, String email);
    
    List<UserEntity> listAll();
}
