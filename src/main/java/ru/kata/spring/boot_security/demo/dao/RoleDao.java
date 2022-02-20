package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    Role getRole(long id);

    List<Role> getAllRoles();

    void updateRole(Role role);

    void deleteRole(long id);
}
