package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepositoryGateway;
import br.com.alura.codechella.domain.entities.user.UserEntity;

public class CreateUserUserCase {
    
    private final UserRepositoryGateway userRepositoryGateway;
    
    public CreateUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }
    
    public UserEntity createUser(UserEntity userEntity) {
        return userRepositoryGateway.create(userEntity);
    }
    
}
