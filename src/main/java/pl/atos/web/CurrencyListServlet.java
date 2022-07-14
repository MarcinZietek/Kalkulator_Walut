package pl.atos.web;

import pl.atos.Dao.KalkulatorDao;
import pl.atos.model.Kalkulator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CurrencyListServlet", value = "/currencyListServlet")
public class CurrencyListServlet  extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();

            KalkulatorDao kalkulatorDao = new KalkulatorDao();
            List<Kalkulator> kalkulatorList = kalkulatorDao.getValues();
            session.setAttribute("kalkulatorList", kalkulatorList);
            if (session.getAttribute("kalkulatorList") != null){
                request.setAttribute("kalkulatorList", session.getAttribute("kalkulatorList"));
                getServletContext().getRequestDispatcher("/kalkulator.jsp")
                        .forward(request, response);
            }else{
                response.getWriter().append("No values");
                getServletContext().getRequestDispatcher("/adminAddServlet").forward(request,response);
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
}

