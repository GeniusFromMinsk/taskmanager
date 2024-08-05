package com.itacademy.courses.dao;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.User;
import com.itacademy.courses.db.DBConnection;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUser(int userId) {
        boolean isDeleted = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.remove(user);
                transaction.commit();
                isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean updateUser(User user) {
        boolean isUpdated = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User existingUser = session.get(User.class, user.getUserId());
            if (existingUser != null) {
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                session.merge(existingUser);
                transaction.commit();
                isUpdated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    public User getUserById(int userId) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try (Session session = sessionFactory.openSession()) {
            users = session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean isUserExists(String email, String username) {
        Long count;
        try (Session session = sessionFactory.openSession()) {
            count = session.createQuery("select count(*) from User where email = :email or username = :username", Long.class)
                    .setParameter("email", email)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0L;
        }
        return count > 0;
    }
}
