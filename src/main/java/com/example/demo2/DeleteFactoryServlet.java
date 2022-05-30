package com.example.demo2;

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
import java.util.List;

@WebServlet(name="deleteFactory",value = "/deleteFactory")
public class DeleteFactoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Souvenir> souvenirs = SouvenirModel.getInstance().list().stream()
                        .filter(s->s.getFactory().getId()==id)
                                .toList();
        for (Souvenir s : souvenirs) {
            SouvenirModel.getInstance().delete(s.getId());
        }

        FactoryModel.getInstance().deleteFactory(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listFactoryView.jsp");
        requestDispatcher.forward(request, response);
    }

}
