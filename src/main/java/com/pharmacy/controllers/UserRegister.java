package com.pharmacy.controllers;

import com.pharmacy.daoImp.UserDaoImp;
import com.pharmacy.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")

public class UserRegister extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDaoImp userCrud = new UserDaoImp();
        User user = new User(name,username,email,password);
        userCrud.addUser(user);
        res.sendRedirect("userLogin");

        System.out.println("User registered successfully");


    }
}

