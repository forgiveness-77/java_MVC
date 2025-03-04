package com.pharmacy.controllers;

import com.pharmacy.daoImp.MedicineDaoImp;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteMedicine")
public class DeleteMedicine extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        int id = Integer.parseInt(req.getParameter("id"));
        MedicineDaoImp medicineCrud= new MedicineDaoImp();
        medicineCrud.deleteMedicine(id);
        resp.sendRedirect("getMedicine");
    }
}
