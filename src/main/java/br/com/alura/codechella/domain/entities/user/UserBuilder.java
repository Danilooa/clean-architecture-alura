package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.AddressValueObject;

import java.time.LocalDate;

public class UserBuilder {

    private UserEntity userEntity;

    public UserBuilder withCpfNameBirthDate(String cpf,
                                            String nome,
                                            LocalDate dataNascimento) {
        this.userEntity = new UserEntity(cpf, nome, dataNascimento, 19, "");
        return this;
    }


    public UserBuilder withAddress(String cep,
                                   String numero,
                                   String complemento) {
        this.userEntity.setAddress(new AddressValueObject(cep, numero, complemento));
        return this;
    }

    public UserBuilder withAge(Integer idade) {
        this.userEntity.setAge(idade);
        return this;
    }

    public UserEntity build() {
        return this.userEntity;
    }
}
