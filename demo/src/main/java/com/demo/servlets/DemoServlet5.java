package com.demo.servlets;

import com.demo.entity.Account;
import com.demo.helpers.UploadHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 10, fileSizeThreshold = 1024 * 1024 * 10)
@WebServlet("/demo5")
public class DemoServlet5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DemoServlet5() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            doGet_Index(req, resp);
        } else {
            if (action.equalsIgnoreCase("search-by-keyword")) {
                doGet_SearchByKeyword(req, resp);
            } else if (action.equalsIgnoreCase("search-by-price")) {
                doGet_SearchByPrice(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("login")) {
            doPost_Login(req, resp);
        } else {
            if (action.equalsIgnoreCase("find-by-date")) {
                try {
                    doPost_findByDate(req, resp);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else if (action.equalsIgnoreCase("upload")) {
                doPost_upload(req, resp);
            } else if (action.equalsIgnoreCase("uploads")) {
                doPost_uploads(req, resp);
            }
        }
    }

    protected void doGet_Index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/demo5/index.jsp").forward(req, resp);
    }

    protected void doGet_SearchByKeyword(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String keyword = req.getParameter("keyword");
        System.out.printf("keyword: %s%n", keyword);
        resp.sendRedirect("demo5");
    }

    protected void doGet_SearchByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        double min = Double.parseDouble(req.getParameter("min"));
        System.out.printf("min: %s%n", min);
        double max = Double.parseDouble(req.getParameter("max"));
        System.out.printf("max: %s%n", max);
        resp.sendRedirect("demo5");
    }




    protected void doPost_Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username: %s%n", username);
        System.out.printf("password: %s%n", password);
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.printf("hash: %s%n", hash);
        resp.sendRedirect("demo5");
    }



    protected void doPost_findByDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date from = simpleDateFormat.parse(req.getParameter("from"));
        Date to = simpleDateFormat.parse(req.getParameter("to"));
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("from" + simpleDateFormat.format(from));
        System.out.println("to" + simpleDateFormat.format(to));
        resp.sendRedirect("demo5");
    }

    protected void doPost_upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Part file = req.getPart("file");
        System.out.println("File Info");
        System.out.println("name: " + file.getSubmittedFileName());
        System.out.println("size: " + file.getSize());
        System.out.println("type: " + file.getContentType());

        // Upload file
        String fileName = UploadHelper.uploadFile("asserts/images", req, file);
        System.out.println("file name: " + fileName);
        resp.sendRedirect("demo5");
    }

    protected void doPost_uploads(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        List<Part> partList = (List<Part>) req.getParts();
        System.out.println("parts: " + partList.size());
        for (Part part : partList) {
            if (part.getName().equalsIgnoreCase("files")) {
                String fileName = UploadHelper.uploadFile("asserts/images", req, part);
            }
            System.out.println(part.getName());

        }
        resp.sendRedirect("demo5");
    }
}
