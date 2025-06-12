package br.com.alura.codechella.domain;

public class AddressValueObject {

    private final String cep;

    private final String number;

    private final String details;

    public AddressValueObject(String cep, String number, String details) {
        this.cep = cep;
        this.number = number;
        this.details = details;
    }

    public String getCep() {
        return cep;
    }

    public String getNumber() {
        return number;
    }

    public String getDetails() {
        return details;
    }
}
