package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/home")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1>Hello, World!</h1>");

        // List all ads
        request.setAttribute("all", DaoFactory.getAdsDao().all());

        // List Cars ads
        request.setAttribute("cars", DaoFactory.getAdsDao().selWhile((long) 7));

        // List Computers ads
        request.setAttribute("computers", DaoFactory.getAdsDao().selWhile((long) 3));

        // Jobs
        request.setAttribute("jobs", DaoFactory.getAdsDao().selWhile((long) 5));

        // Furniture
        request.setAttribute("furniture", DaoFactory.getAdsDao().selWhile((long) 8));

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
