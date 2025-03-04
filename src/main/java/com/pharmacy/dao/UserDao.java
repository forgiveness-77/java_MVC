package com.pharmacy.dao;

import com.pharmacy.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User User);
    List<User> getAllUsers();
    User getUserById(int id);
    void updateUser(User User);
    void deleteUser(int id);
}
