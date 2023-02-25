package br.ada.americanas.helloworldservlet.operacao;

import java.math.BigDecimal;

public interface Operacao {

    BigDecimal execute(BigDecimal first, BigDecimal second);

    String simboloMatematico();

}
