package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.application.gateway.UserRepositoryGateway;
import br.com.alura.codechella.domain.entities.user.UserEntity;
import br.com.alura.codechella.infra.jpa.UserJpaRepository;
import br.com.alura.codechella.infra.jpa.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserJpaRepositoryGateway implements UserRepositoryGateway {
    
    private final UserJpaRepository userJpaRepository;
    private final UserModelMapper userModelMapper;
    
    public UserJpaRepositoryGateway(UserJpaRepository userJpaRepository, UserModelMapper userModelMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userModelMapper = userModelMapper;
    }
    
    @Override
    public UserEntity create(UserEntity userEntity) {
        UserModel userModel = userModelMapper.toModel(userEntity);
        userJpaRepository.save(userModel);
        return userModelMapper.toEntity(userModel);
    }
    
    @Override
    public List<UserEntity> listAll() {
        return userJpaRepository
                .findAll()
                .stream()
                .map(userModelMapper::toEntity)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserEntity update(String cpf, String email) {
        UserModel model = userJpaRepository.findByCpf(cpf);
        model.setEmail(email);
        userJpaRepository.save(model);
        return userModelMapper.toEntity(model);
    }
}
