package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.ListUserUserCase;
import br.com.alura.codechella.application.usecases.UpdateUserUserCase;
import br.com.alura.codechella.application.usecases.CreateUserUserCase;
import br.com.alura.codechella.domain.entities.user.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final CreateUserUserCase createUserUserCase;
    private final UpdateUserUserCase updateUserUserCase;
    private final ListUserUserCase listUserUserCase;
    private final UserDtoMapper userDtoMapper;
    
    public UserController(CreateUserUserCase createUserUserCase,
                          UpdateUserUserCase updateUserUserCase,
                          ListUserUserCase listUserUserCase,
                          UserDtoMapper userDtoMapper) {
        
        this.createUserUserCase = createUserUserCase;
        this.updateUserUserCase = updateUserUserCase;
        this.listUserUserCase = listUserUserCase;
        this.userDtoMapper = userDtoMapper;
    }
    
    @PostMapping
    public UserDto createUser(@RequestBody UserDto dto) {
        UserEntity domainCreatable = userDtoMapper.toEntity(dto);
        UserEntity domainCreated = createUserUserCase.createUser(domainCreatable);
        return userDtoMapper.toDto(domainCreated);
    }
    
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto dto) {
        UserEntity domainUpdatable = userDtoMapper.toEntity(dto);
        UserEntity domainUpdated = updateUserUserCase.updateUser(domainUpdatable);
        return userDtoMapper.toDto(domainUpdated);
    }
    
    @GetMapping
    public List<UserDto> listAllUsers() {
        return listUserUserCase
                .listAllUser()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }
    
}
