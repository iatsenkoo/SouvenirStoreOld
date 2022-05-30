package com.example.demo2;

import com.example.demo2.model.FactoryModel;
import com.example.demo2.model.SouvenirModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="deleteSouvenir",value = "/deleteSouvenir")
public class DeleteSouvenirServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SouvenirModel.getInstance().delete(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listSouvenirView.jsp");
        requestDispatcher.forward(request, response);
    }

}
