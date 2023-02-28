package br.ada.americanas.helloworldservlet.operacao;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class OperacaoValidator {

    public void validar(
            BigDecimal first,
            BigDecimal second,
            String operador
    ) {
        if (first == null) {
            throw new RuntimeException("O primerio valor não pode ser nulo");
        }
        if (second == null) {
            throw new RuntimeException("O segundo valor não poder ser nulo");
        }
        if (operador == null) {
            throw new RuntimeException("O operador não poder ser nulo");
        }
    }

}
