package br.ada.americanas.helloworldservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcularServlet", value = "/calcular")
public class CalcularServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer first = Integer.valueOf(request.getParameter("first"));
        Integer second = Integer.valueOf(request.getParameter("second"));

        Integer calculo = first + second;

        request.setAttribute("result", calculo);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

}
