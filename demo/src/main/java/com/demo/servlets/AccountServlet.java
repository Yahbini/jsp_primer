package com.demo.servlets;

import com.demo.entity.Account;
import com.demo.models.AccountModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            doGet_login(req, resp);
        } else {
            if (action.equalsIgnoreCase("welcome")) {
                doGet_welcome(req, resp);
            } else if (action.equalsIgnoreCase("logout")) {
                doGet_logout(req, resp);
            } else if (action.equalsIgnoreCase("register")) {
                doGet_Register(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("login")) {
            doPost_login(req, resp);
        } else if (action.equalsIgnoreCase("register")) {
            doPost_Register(req, resp);
        }
    }


    protected void doGet_login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/account/login.jsp").forward(req, resp);
    }

    protected void doGet_welcome(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.getRequestDispatcher("WEB-INF/views/account/welcome.jsp").forward(req, resp);
    }

    protected void doGet_logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("account");
    }


    protected void doGet_Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Account account = new Account();
        account.setUsername("acc1");
        req.setAttribute("account", account);
        req.getRequestDispatcher("/WEB-INF/views/account/register.jsp").forward(req, resp);
    }

    protected void doPost_login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel accountModel = new AccountModel();
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        if (accountModel.login(username, password)) {
            resp.sendRedirect("account?action=welcome");
        } else {
            req.setAttribute("msg", "Invalid username or password");
            req.getRequestDispatcher("WEB-INF/views/account/login.jsp").forward(req, resp);
        }
    }

    protected void doPost_Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Account account = new Account();
        account.setUsername(req.getParameter("username").trim());
        String passwrod = req.getParameter("password");
        account.setPassword(BCrypt.hashpw(passwrod, BCrypt.gensalt()));
        System.out.println("Username: " + account.getUsername());
        System.out.println("Password: " + account.getPassword());
        resp.sendRedirect("account?action=register");
    }


}
