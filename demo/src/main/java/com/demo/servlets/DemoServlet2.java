package com.demo.servlets;

import com.demo.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/demo2")
public class DemoServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DemoServlet2() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        List<String> names = List.of("Name1", "Name2", "Name3", "Name4", "Name5", "Name6");
        req.setAttribute("names", names);
        req.setAttribute("products", productModel.findAll());
        req.setAttribute("total2", productModel.total());

        req.getRequestDispatcher("/WEB-INF/views/demo2/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
