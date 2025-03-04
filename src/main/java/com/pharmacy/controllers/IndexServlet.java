package com.pharmacy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.sendRedirect("login.jsp");
    }
}
