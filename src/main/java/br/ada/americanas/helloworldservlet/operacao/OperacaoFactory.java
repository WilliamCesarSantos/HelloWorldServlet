package br.ada.americanas.helloworldservlet.operacao;

public class OperacaoFactory {

    public static Operacao create(String simboloMatematico) {
        Operacao operacao;
        switch (simboloMatematico) {
            case "+":
                operacao = new SomaOperacao();
                break;
            case "-":
                operacao = new SubtracaoOperacao();
                break;
            default:
                throw new RuntimeException("Operacao não permitida");
        }
        return operacao;
    }

}
