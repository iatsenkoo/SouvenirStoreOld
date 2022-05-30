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
import java.util.List;

@WebServlet(name="editFactory",value = "/editFactory")
public class EditFactoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Factory> factories = FactoryModel.getInstance().list().stream()
                        .filter(s->s.getId()==id)
                        .toList();
        request.setAttribute("factory",factories.get(0));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editFactory.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        int id = Integer.parseInt(request.getParameter("id"));
        FactoryModel.getInstance().editFactory(id,name,country);
        request.setAttribute("errorString", "factory was edited");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listFactoryView.jsp");
        requestDispatcher.forward(request, response);
    }
}
