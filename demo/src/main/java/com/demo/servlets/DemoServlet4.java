package com.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo4")
public class DemoServlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DemoServlet4() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            doGet_Index(req, resp);
        } else {
            if(action.equalsIgnoreCase("menu1")) {
                doGet_Menu1(req, resp);
            } else if(action.equalsIgnoreCase("menu2")) {
                doGet_Menu2(req, resp);
            }
            else if(action.equalsIgnoreCase("menu3")) {
                doGet_Menu3(req, resp);
            }
        }
    }

    protected void doGet_Menu1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/demo4/menu1.jsp").forward(req, resp);
    }

    protected void doGet_Menu2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/demo4/menu2.jsp").forward(req, resp);
    }

    protected void doGet_Menu3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/demo4/menu3.jsp").forward(req, resp);
    }

    protected void doGet_Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/demo4/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
