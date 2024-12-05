package com.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo3")
public class DemoServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DemoServlet3() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
        }

        if(req.getParameter("username") != null) {
            String username = req.getParameter("username");
            System.out.println(username);
        }

        req.getRequestDispatcher("/WEB-INF/views/demo3/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
