package br.ada.americanas.helloworldservlet;

import br.ada.americanas.helloworldservlet.operacao.Operacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HistoricoServlet", value = "/historico")
public class HistoricoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        var operacoes = (List<Operacao>) session.getAttribute("historico_operacoes");
        if (operacoes == null) {
            operacoes = new ArrayList<>();
        }
        request.setAttribute("historico_operacoes", operacoes);
        request.getRequestDispatcher("/historico.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
