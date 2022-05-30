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

@WebServlet(name="editSouvenir",value = "/editSouvenir")
public class EditSouvenirServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Souvenir> souvenirs = SouvenirModel.getInstance().list().stream()
                        .filter(s->s.getId()==id)
                        .toList();
        request.setAttribute("souvenir",souvenirs.get(0));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editSouvenir.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFactory = Integer.parseInt(request.getParameter("idFactory"));
        List<Factory> factories = FactoryModel.getInstance().list().stream()
                .filter(s->s.getId()==idFactory)
                .toList();
        Factory factory;
        if (factories.isEmpty()){
            factory = new Factory(Integer.parseInt(request.getParameter("idFactory")),
                    request.getParameter("nameFactory"),
                    request.getParameter("countryFactory"));
            FactoryModel.getInstance().add(factory);
        }else{
            factory = factories.get(0);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfProduction = LocalDate.parse(request.getParameter("dateOfProduction"),dtf);

        Souvenir souvenir = new Souvenir(Integer.parseInt(request.getParameter("id")),
                                         request.getParameter("name"),
                                        factory,
                                        dateOfProduction,
                                        Double.parseDouble(request.getParameter("price")));
        SouvenirModel.getInstance().edit(souvenir);

        request.setAttribute("errorString", "souvenir was edited");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listSouvenirView.jsp");
        requestDispatcher.forward(request, response);
    }
}
