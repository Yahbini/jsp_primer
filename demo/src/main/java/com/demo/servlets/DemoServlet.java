package com.demo.servlets;

import com.demo.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DemoServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        req.setAttribute("id", 123);
        req.setAttribute("username", "Phoebe");
        req.setAttribute("photo", "a.png");
        req.setAttribute("width", "100");
        req.setAttribute("height", "100");
        req.setAttribute("product", productModel.findById(2));
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
