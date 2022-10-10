package com.example.RestTest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zulfa Attar
 */
public class GetSessionFactory {

    static SessionFactory sessionFactory;
    private GetSessionFactory(){

    }

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
