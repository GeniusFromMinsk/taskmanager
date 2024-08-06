package com.itacademy.courses.db;

import com.itacademy.courses.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                sessionFactory = new Configuration()
                        .addAnnotatedClass(Category.class)
                        .addAnnotatedClass(Project.class)
                        .addAnnotatedClass(ProjectTask.class)
                        .addAnnotatedClass(Report.class)
                        .addAnnotatedClass(Subtask.class)
                        .addAnnotatedClass(Tag.class)
                        .addAnnotatedClass(Task.class)
                        .addAnnotatedClass(TaskCategory.class)
                        .addAnnotatedClass(TaskTag.class)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e){
                System.out.println("Exception during  getting session factory: " + e);
            }
        }
        return sessionFactory;
    }
}

