package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUser(long id);

    User getUserByUsername(String username);

    List getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);
}
