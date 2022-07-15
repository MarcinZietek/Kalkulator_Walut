package pl.atos.web;

import pl.atos.Dao.KalkulatorDao;
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

        String theCommand = request.getParameter("command");
        if (theCommand == null){
            theCommand = "List";
        }

        switch (theCommand){
            case "List":
                listCurrency(request, response);
                break;
            case "Exchange":
                exchangeCurrency(request, response);
                break;
        }
        
        getServletContext().getRequestDispatcher("/exchange-form.jsp").forward(request, response);

    }

    private void exchangeCurrency(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currencyId = Integer.parseInt(request.getParameter("currencyId"));
        Kalkulator theCurrency;
        KalkulatorDao kalkulatorDao = new KalkulatorDao();
        theCurrency = kalkulatorDao.getCurrency(currencyId);
        request.setAttribute("currencyId", theCurrency);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/exchange-form.jsp");
        requestDispatcher.forward(request, response);
    }

    private void listCurrency(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KalkulatorDao kalkulatorDao = new KalkulatorDao();
        List<Kalkulator> kalkulatorList = kalkulatorDao.getValues();
        request.setAttribute("kalkulatorList", kalkulatorList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/kalkulator.jsp");
                requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        String currency = request.getParameter("currency");
        float rates = Float.parseFloat(request.getParameter("rates"));
        float amount =  Float.parseFloat(request.getParameter("amount"));

        float euro = amount * rates;
        printWriter.append(currency).append(" - ");
        printWriter.append("rate : ").append(String.valueOf(rates));
        printWriter.append(" ---> You have got ").append(String.valueOf(euro)).append(" ").append(currency);
        printWriter.write("\n");
        printWriter.append("<a href=\"currencyListServlet" + "\">Back to list page</a>");
    }

}
