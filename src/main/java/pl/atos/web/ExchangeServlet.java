package pl.atos.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExchangeServlet", value = "/exchangeServlet")
public class ExchangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/exchange-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();

        String currency = request.getParameter("currency");
        float rates = 0;
        float amount = 0;


        String ratesString = request.getParameter("rates");
        String amountString = request.getParameter("amount");


        rates = Float.parseFloat(ratesString);
        amount = Float.parseFloat(amountString);
        float euro = amount * rates;

        printWriter.append(currency).append(" - ");
        printWriter.append("rate : ").append(String.valueOf(rates));
        printWriter.append(" ---> You have got ").append(String.valueOf(euro)).append(" Euros");

    }

}
