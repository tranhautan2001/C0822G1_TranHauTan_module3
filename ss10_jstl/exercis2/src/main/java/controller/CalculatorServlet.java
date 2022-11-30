package controller;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "Calculator Servlet" ,urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("stn"));
        float secondOperand = Integer.parseInt(request.getParameter("sth"));
        char operator = request.getParameter("operator").charAt(0);
        float result = Calculator.calculator(firstOperand,secondOperand,operator);

        request.setAttribute("stn",firstOperand);
        request.setAttribute("op",operator);
        request.setAttribute("sth",secondOperand);
        request.setAttribute("rs",result);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
