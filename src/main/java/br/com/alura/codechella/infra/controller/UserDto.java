package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.domain.AddressValueObject;

import java.time.LocalDate;

public class UserDto {
    
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String email;
    private AddressValueObject addressValueObject;
    private Integer age;
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
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
        return addressValueObject;
    }
    
    public void setAddress(AddressValueObject addressValueObject) {
        this.addressValueObject = addressValueObject;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
