package com.pharmacy.daoImp;

import com.pharmacy.dao.UserDao;
import com.pharmacy.models.User;

import java.sql.*;
import java.util.*;
import com.pharmacy.utility.DBConnection;

public class UserDaoImp implements UserDao {
    private Connection conn;

    public UserDaoImp() {
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
    public void addUser(User user) {
        String query = "INSERT INTO users (name, username, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            System.out.println("User added to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> Users = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                Users.add(new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return Users;
    }

    @Override
    public User getUserById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    public User getUserByEmail(String email) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE users WHERE user_id=? SET name=?, username=?, email=?, password=? WHERE id=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

}
