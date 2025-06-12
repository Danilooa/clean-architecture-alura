package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.AddressValueObject;

import java.time.LocalDate;

public class UserEntity {

    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;
    private AddressValueObject address;
    private Integer age;

    public UserEntity(String cpf,
                      String name,
                      LocalDate birthDate,
                      Integer age,
                      String email) {
        this.setCpf(cpf);
        this.name = name;
        this.birthDate = birthDate;
        this.setAge(age);
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!CpfValidation.validate(cpf)) {
            throw new IllegalArgumentException("Invalid Cpf.");
        }
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressValueObject getAddress() {
        return address;
    }

    public void setAddress(AddressValueObject addressValueObject) {
        this.address = addressValueObject;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (!LegalAgeValidation.validate(age)) {
            throw new IllegalArgumentException(
                    "The user must be of legal age " + LegalAgeValidation.LEGAL_AGE
            );
        }
        this.age = age;
    }
}
