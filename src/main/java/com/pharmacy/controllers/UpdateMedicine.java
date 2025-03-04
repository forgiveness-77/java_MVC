package com.pharmacy.controllers;

import com.pharmacy.dao.MedicineDao;
import com.pharmacy.daoImp.MedicineDaoImp;
import com.pharmacy.models.Medicine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateMedicine")
public class UpdateMedicine extends HttpServlet {

    private MedicineDao medicineDAO;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        MedicineDaoImp medicineCrud = new MedicineDaoImp();
        Medicine medicine = new Medicine(id, name, price, stock);
        medicineCrud.updateMedicine(medicine);
        resp.sendRedirect("getMedicine");

    }
}
