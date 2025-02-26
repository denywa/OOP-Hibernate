package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
           
            Configuration configuration = new Configuration().configure();
          
            configuration.addAnnotatedClass(com.example.Students.class);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
           
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        
        getSessionFactory().close();
    }
}
