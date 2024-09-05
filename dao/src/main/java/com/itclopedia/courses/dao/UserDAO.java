package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertUser(User user) {
        entityManager.persist(user);
    }

    public void deleteUser(int userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public boolean isUserExists(String email, String username) {
        Long count = entityManager.createQuery("select count(*) from User where email = :email or username = :username", Long.class)
                .setParameter("email", email)
                .setParameter("username", username)
                .getSingleResult();
        return count > 0;
    }
}
