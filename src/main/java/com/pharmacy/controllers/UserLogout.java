package com.pharmacy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")

public class UserLogout extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Invalidate session
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            System.out.println("Session Invalidated!");
        }

        // Redirect to index.jsp
        res.sendRedirect("userLogin");
    }

}
