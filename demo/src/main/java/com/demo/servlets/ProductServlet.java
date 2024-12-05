package com.demo.servlets;

import com.demo.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            doGet_Index(req, resp);
        } else {
            if (action.equalsIgnoreCase("search-by-keyword")) {
                doGet_searchByKeyword(req, resp);
            } else if (action.equalsIgnoreCase("search-by-price")) {
                doGet_searchByPrice(req, resp);
            }
        }
    }

    protected void doGet_Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel productModel = new ProductModel();
        req.setAttribute("products", productModel.findAll());
        req.getRequestDispatcher("/WEB-INF/views/product/index.jsp").forward(req, resp);
    }

    protected void doGet_searchByKeyword(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        ProductModel productModel = new ProductModel();
        String keyword = req.getParameter("keyword").trim();
        req.setAttribute("products", productModel.findByKeyword(keyword));
        ;
        req.getRequestDispatcher("/WEB-INF/views/product/index.jsp").forward(req, resp);
    }

    protected void doGet_searchByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        ProductModel productModel = new ProductModel();
        double min = Double.parseDouble(req.getParameter("min"));
        double max = Double.parseDouble(req.getParameter("max"));
        req.setAttribute("products", productModel.findByPrice(min, max));
        req.getRequestDispatcher("/WEB-INF/views/product/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
