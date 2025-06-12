package br.com.alura.codechella.domain.entities.user;

public class CpfValidation {

    private static final String REGEX_CPF = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";

    public static Boolean validate(String cpf) {
        if (cpf == null) return false;
        if (cpf.matches(REGEX_CPF)) return true;
        return false;
    }

}
