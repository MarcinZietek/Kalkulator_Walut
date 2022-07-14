package pl.atos.web;

import pl.atos.model.Kalkulator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ExchangeServlet", value = "/exchangeServlet")
public class ExchangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/exchange-form.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter printWriter = response.getWriter();

        String currency = request.getParameter("currency");
        int id = Integer.parseInt(request.getParameter("id"));
        float rates = Float.parseFloat(request.getParameter("rates"));
        float amount =  Float.parseFloat(request.getParameter("amount"));;

        float euro = amount * rates;
        printWriter.append(String.valueOf(id)).append(" : ");
        printWriter.append(currency).append(" - ");
        printWriter.append("rate : ").append(String.valueOf(rates));
        printWriter.append(" ---> You have got ").append(String.valueOf(euro)).append(" Euros");
//        getServletContext().getRequestDispatcher("/exchange-form.jsp").forward(request, response);

    }

}
