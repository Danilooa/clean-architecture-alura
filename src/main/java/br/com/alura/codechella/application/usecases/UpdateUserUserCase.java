package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepositoryGateway;
import br.com.alura.codechella.domain.entities.user.UserEntity;

public class UpdateUserUserCase {
    
    private final UserRepositoryGateway userRepositoryGateway;
    
    public UpdateUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }
    
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepositoryGateway.update(userEntity.getCpf(), userEntity.getEmail());
    }
    
}
