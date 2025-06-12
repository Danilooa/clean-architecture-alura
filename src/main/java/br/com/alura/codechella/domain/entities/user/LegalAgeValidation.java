package br.com.alura.codechella.domain.entities.user;

public class LegalAgeValidation {

    public static final Integer LEGAL_AGE = 18;

    public static Boolean validate(Integer age) {
        if (age < LEGAL_AGE) return false;
        return true;
    }

}
