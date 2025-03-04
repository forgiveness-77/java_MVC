package com.pharmacy.controllers;

import com.pharmacy.daoImp.UserDaoImp;
import com.pharmacy.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")

public class UserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserDaoImp userCrud = new UserDaoImp();
        User user = userCrud.getUserByEmail(email);

        if( user==null || !user.getPassword().equals(password)){
            System.out.println(user.getEmail()+" "+user.getPassword());
            System.out.println("The user is null or the password is incorrect");
            resp.sendRedirect("userlogin");
            throw new IOException("The user doesn't exist");

        }else {
            HttpSession session = req.getSession(true);
            session.setAttribute("email", email);
            session.setAttribute("username", user.getUsername());
            resp.sendRedirect("medicinePage");
        }
    }
}
