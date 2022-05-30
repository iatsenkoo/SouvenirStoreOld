package com.example.demo2;

import com.example.demo2.entities.Factory;
import com.example.demo2.entities.Souvenir;
import com.example.demo2.model.SouvenirModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo2.model.FactoryModel.getInstance;

@WebServlet(name="listFactory",value = "/listFactory")
public class ListFactoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Factory> factories = getInstance().list();


        if(factories.isEmpty()){
            request.setAttribute("errorString","no one factory find");
        } else {
            request.setAttribute("factoryList", factories);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listFactoryView.jsp");
        requestDispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Factory> factories = getInstance().list();
        List<Factory> factoriesSearch = new ArrayList<>();
        if(request.getParameter("nameSouvenir")!=null && request.getParameter("year")!=null){
            List<Souvenir> souvenirs = SouvenirModel.getInstance().list().stream()
                    .filter(s->s.getName().equals(request.getParameter("nameSouvenir")))
                    .filter(s->s.getDateOfProduction().getYear()==Integer.parseInt(request.getParameter("year")))
                    .toList();
            for (Souvenir s : souvenirs) {
                factoriesSearch.add(s.getFactory());
            }
            if(factoriesSearch.isEmpty()){
                request.setAttribute("errorString","no one factory find for this parameters");
            } else {
                request.setAttribute("factoryList", factoriesSearch);
            }
        }else if(request.getParameter("price")!=null){
            List<Souvenir> souvenirs = SouvenirModel.getInstance().list().stream()
                    .filter(s->s.getPrice()<Double.parseDouble(request.getParameter("price")))
                    .toList();
            for (Souvenir s : souvenirs) {
                factoriesSearch.add(s.getFactory());
            }
            if(factoriesSearch.isEmpty()){
                request.setAttribute("errorString","no one factory find for this parameters");
            } else {
                request.setAttribute("factoryList", factoriesSearch);
            }
        } else {
            if (factories.isEmpty()) {
                request.setAttribute("errorString", "no one factory find for this parameters");
            } else {
                request.setAttribute("factoryList", factories);
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listFactoryView.jsp");
        requestDispatcher.forward(request, response);
    }
}
