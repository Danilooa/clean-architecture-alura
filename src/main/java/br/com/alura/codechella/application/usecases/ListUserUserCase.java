package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateway.UserRepositoryGateway;
import br.com.alura.codechella.domain.entities.user.UserEntity;

import java.util.List;

public class ListUserUserCase {
    
    private final UserRepositoryGateway userRepositoryGateway;
    
    public ListUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }
    
    public List<UserEntity> listAllUser() {
        return userRepositoryGateway.listAll();
    }
    
}
