package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try {
            user = (User) em.createQuery("select user from User user where user.username = :username")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException ignore) {

        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(getUser(id));
    }
}