package com.pharmacy.daoImp;

import com.pharmacy.dao.MedicineDao;
import com.pharmacy.models.Medicine;
import com.pharmacy.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImp implements MedicineDao {

    private Connection conn;

    public MedicineDaoImp() {
        try {
            conn = DBConnection.getConn();
            if (conn == null) {
                throw new SQLException("Database connection failed.");
            }
        } catch (Exception e) {
            System.err.println("Error initializing database connection: " + e.getMessage());
        }
    }

    @Override
    public void addMedicine(Medicine medicine) {
        String query = "INSERT INTO medicine (name, price, stock) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, medicine.getName());
            ps.setDouble(2, medicine.getPrice());
            ps.setInt(3, medicine.getStock());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM medicine");
            while (rs.next()) {
                medicines.add(new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public Medicine getMedicineById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM medicine WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Medicine(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMedicine(Medicine medicine) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE medicine SET name=?, price=?, stock=? WHERE id=?");
            ps.setString(1, medicine.getName());
            ps.setDouble(2, medicine.getPrice());
            ps.setInt(3, medicine.getStock());
            ps.setInt(4, medicine.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteMedicine(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM medicine WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
