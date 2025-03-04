package com.pharmacy.controllers;

import com.pharmacy.daoImp.MedicineDaoImp;
import com.pharmacy.daoImp.UserDaoImp;
import com.pharmacy.models.Medicine;
import com.pharmacy.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addMedicine")

public class AddMedicine extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession(false); // Do not create a new session
        if (session == null || session.getAttribute("email") == null) {
            res.sendRedirect("login.jsp");
            return;
        }


        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock =  Integer.parseInt(req.getParameter("stock"));

        MedicineDaoImp medCrud = new MedicineDaoImp();

        Medicine med = new Medicine(name,price,stock);

        medCrud.addMedicine(med);

        System.out.println("Medicine Added Successfully!");

        res.sendRedirect("getMed");

    }
}
