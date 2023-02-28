package br.ada.americanas.helloworldservlet.operacao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

/**
 * Marca a classe como um bean. Orienta o servidor a iniciar essa classe e não será necessário o uso do new
 */
@ApplicationScoped
public class OperacaoService {

    private OperacaoValidator validator;

    @Inject
    public OperacaoService(OperacaoValidator validator) {
        this.validator = validator;
    }

    public BigDecimal executar(
            BigDecimal first,
            BigDecimal second,
            String operador
    ) {
        validator.validar(first, second, operador);
        Operacao operacao = OperacaoFactory.create(operador);
        return operacao.execute(first, second);
    }

}
