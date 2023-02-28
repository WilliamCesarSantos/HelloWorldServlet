package br.ada.americanas.helloworldservlet;

import br.ada.americanas.helloworldservlet.operacao.Operacao;
import br.ada.americanas.helloworldservlet.operacao.OperacaoFactory;
import br.ada.americanas.helloworldservlet.operacao.OperacaoService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jboss.weld.environment.se.Weld;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalcularServlet", value = "/calcular")
public class CalcularServlet extends HttpServlet {

    private OperacaoService service;

    @Override
    public void init() throws ServletException {
        super.init();
        Weld weld = new Weld();
        var container = weld.initialize();

        service = container.select(OperacaoService.class).get();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigDecimal first = new BigDecimal(request.getParameter("first"));
        BigDecimal second = new BigDecimal(request.getParameter("second"));
        String operator = request.getParameter("operator");

        var result = service.executar(first, second, operator);
//        var operacoes = recuperaOperacoes(request);
//        operacoes.add(operacao);

        request.setAttribute("result", result);
        request.setAttribute("operator", operator);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private List<Operacao> recuperaOperacoes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Operacao> operacoes = (List<Operacao>) session.getAttribute("historico_operacoes");
        if (operacoes == null) {
            operacoes = new ArrayList<>();
            session.setAttribute("historico_operacoes", operacoes);
        }
        return operacoes;
    }

}
