package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.infra.gateway.UserModelMapper;
import br.com.alura.codechella.infra.jpa.model.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class UserEntityEntityTest {
    @Test
    public void shouldNotCreateUserWithInvalidCpf() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new UserEntity(
                        "123456789-99",
                        "Danilo",
                        LocalDate.parse("1990-09-08"),
                        19,
                        "email@email.com"
                )
        );
    }
    
    @Test
    public void shouldCreateUserWithCpfNameAddressUsingBuilder() {
        UserBuilder userBuilder = new UserBuilder();
        UserEntity userEntity = userBuilder
                .withCpfNameBirthDate(
                        "999.999.999-99",
                        "Danilo",
                        LocalDate.of(1985, 11, 20)
                )
                .build();
        
        Assertions.assertEquals("Danilo", userEntity.getName());
        
        UserEntity userEntityComEndereco = userBuilder
                .withAddress(
                        "88092-300",
                        "90A",
                        "Bloco C Apartamento 106"
                )
                .build();
        
        Assertions.assertEquals("90A", userEntityComEndereco.getAddress().getNumber());
    }
    
    @Test
    public void shouldNotCreateUserUnderLegalAge() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new UserBuilder()
                        .withCpfNameBirthDate(
                                "999.999.999-99",
                                "Danilo",
                                LocalDate.of(1985, 11, 20)
                        )
                        .withAge(17)
                        .build()
        );
    }
    
    @Test
    public void shouldMapDomainToModel() {
        UserModelMapper mapper = Mappers.getMapper(UserModelMapper.class);
     
        UserEntity domain = new UserEntity(
                "888.999.888-99",
                "João",
                LocalDate.of(1985, 10, 18),
                19,
                "email@gmail.com");
        
        UserModel model = mapper.toModel(domain);
        
        Assertions.assertEquals(domain.getAge(), model.getAge());
    }
    
}