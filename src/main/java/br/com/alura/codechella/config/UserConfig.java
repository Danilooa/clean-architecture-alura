package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateway.UserRepositoryGateway;
import br.com.alura.codechella.application.usecases.CreateUserUserCase;
import br.com.alura.codechella.application.usecases.ListUserUserCase;
import br.com.alura.codechella.application.usecases.UpdateUserUserCase;
import br.com.alura.codechella.infra.controller.UserDtoMapper;
import br.com.alura.codechella.infra.gateway.UserJpaRepositoryGateway;
import br.com.alura.codechella.infra.gateway.UserModelMapper;
import br.com.alura.codechella.infra.jpa.UserJpaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    
    @Bean
    CreateUserUserCase createCreateUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserUserCase(userRepositoryGateway);
    }
    
    @Bean
    UpdateUserUserCase createUpdateUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        return new UpdateUserUserCase(userRepositoryGateway);
    }
    
    @Bean
    ListUserUserCase createListUserUserCase(UserRepositoryGateway userRepositoryGateway) {
        return new ListUserUserCase(userRepositoryGateway);
    }
    
    @Bean
    UserJpaRepositoryGateway createUserJpaRepositoryGateway(UserJpaRepository userJpaRepository,
                                                            UserModelMapper userModelMapper) {
        return new UserJpaRepositoryGateway(userJpaRepository, userModelMapper);
    }
    
    @Bean
    UserModelMapper createUserModelMapper() {
        return Mappers.getMapper(UserModelMapper.class);
    }
    
    @Bean
    UserDtoMapper createUserDtoMapper() {
        return Mappers.getMapper(UserDtoMapper.class);
    }
    
}
