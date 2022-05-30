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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="listSouvenir",value = "/listSouvenir")
public class ListSouvenirServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Souvenir> souvenirs = SouvenirModel.getInstance().list();
        if(request.getParameter("idFactory")!=null){
            int idFactory = Integer.parseInt(request.getParameter("idFactory"));
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getId()==idFactory)
                    .toList();
        }
        if(request.getParameter("nameFactory")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getName().equals(request.getParameter("nameFactory")))
                    .toList();
        }
        if(request.getParameter("countryFactory")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getCountry().equals(request.getParameter("countryFactory")))
                    .toList();
        }
        if(request.getParameter("price")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getPrice()<Double.parseDouble(request.getParameter("price")))
                    .toList();
        }
        if(request.getParameter("year")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getDateOfProduction().getYear()==Integer.parseInt(request.getParameter("year")))
                    .toList();
        }

        if(souvenirs.isEmpty()){
            request.setAttribute("errorString","no one souvenirs finded");
        } else {
            request.setAttribute("souvenirList", souvenirs);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listSouvenirView.jsp");
        requestDispatcher.forward(request, response);
    }
    public void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Souvenir> souvenirs = SouvenirModel.getInstance().list();
        if(request.getParameter("idFactory")!=null){
            int idFactory = Integer.parseInt(request.getParameter("idFactory"));
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getId()==idFactory)
                    .toList();
        }
        if(request.getParameter("nameFactory")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getName().equals(request.getParameter("nameFactory")))
                    .toList();
        }
        if(request.getParameter("countryFactory")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getFactory().getCountry().equals(request.getParameter("countryFactory")))
                    .toList();
        }
        if(request.getParameter("price")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getPrice()<Double.parseDouble(request.getParameter("price")))
                    .toList();
        }
        if(request.getParameter("year")!=null){
            souvenirs = souvenirs.stream()
                    .filter(s->s.getDateOfProduction().getYear()==Integer.parseInt(request.getParameter("year")))
                    .toList();
        }

        if(souvenirs.isEmpty()){
            request.setAttribute("errorString","no one souvenirs finded");
        } else {
            request.setAttribute("souvenirList", souvenirs);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listSouvenirView.jsp");
        requestDispatcher.forward(request, response);
    }
}
