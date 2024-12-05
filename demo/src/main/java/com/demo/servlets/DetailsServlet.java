package com.demo.servlets;

import com.demo.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DetailsServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductModel productModel = new ProductModel();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("product", productModel.findById(id));

        req.getRequestDispatcher("/WEB-INF/views/details/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
