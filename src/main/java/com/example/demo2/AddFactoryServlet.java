package com.example.demo2;

import com.example.demo2.entities.Factory;
import com.example.demo2.model.FactoryModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="addFactory",value = "/addFactory")
public class AddFactoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addFactory.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int id = Integer.parseInt(request.getParameter("id"));

        FactoryModel.getInstance().add(new Factory(id,name,country));

        request.setAttribute("errorString", "factory was added");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listFactoryView.jsp");
        requestDispatcher.forward(request, response);
    }
}
