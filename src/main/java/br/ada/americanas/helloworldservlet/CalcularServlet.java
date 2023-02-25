package br.ada.americanas.helloworldservlet;

import br.ada.americanas.helloworldservlet.operacao.Operacao;
import br.ada.americanas.helloworldservlet.operacao.OperacaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalcularServlet", value = "/calcular")
public class CalcularServlet extends HttpServlet {

    private List<Operacao> operacoes = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal first = new BigDecimal(request.getParameter("first"));
        BigDecimal second = new BigDecimal(request.getParameter("second"));
        String operator = request.getParameter("operator");

        Operacao operacao = OperacaoFactory.create(operator);
        operacao.execute(first, second);
        this.operacoes.add(operacao);

        request.setAttribute("historico_operacoes", this.operacoes);
        request.getRequestDispatcher("/historico.jsp").forward(request, response);
    }

}
