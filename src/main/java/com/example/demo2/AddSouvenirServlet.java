package com.example.demo2;

import com.example.demo2.entities.Factory;
import com.example.demo2.entities.Souvenir;
import com.example.demo2.model.FactoryModel;
import com.example.demo2.model.SouvenirModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name="addSouvenir",value = "/addSouvenir")
public class AddSouvenirServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addSouvenir.jsp");
        requestDispatcher.forward(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfProduction = LocalDate.parse(request.getParameter("dateOfProduction"),dtf);
        String nameFactory = request.getParameter("nameFactory");
        String countryFactory = request.getParameter("countryFactory");
        int idFactory = Integer.parseInt(request.getParameter("idFactory"));
        List<Factory> factories = FactoryModel.getInstance().list().stream()
                .filter(s->s.getId()==idFactory)
                .toList();
        Factory factory;
        if (factories.isEmpty()){
            factory = new Factory(idFactory,nameFactory,countryFactory);
            FactoryModel.getInstance().add(factory);
        }else{
            factory = factories.get(0);
        }

        Souvenir souvenir = new Souvenir(id,name,factory,dateOfProduction,price);
        SouvenirModel souvenirModel = SouvenirModel.getInstance();
        souvenirModel.add(souvenir);

        request.setAttribute("errorString", "souvenir was added");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listSouvenirView.jsp");
        requestDispatcher.forward(request, response);
    }
}
