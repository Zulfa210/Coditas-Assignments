package com.connectionprovider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Zulfa Attar
 */
public class SessionFactoryProvider {

    private static SessionFactory sessionFactory= null;

    private SessionFactoryProvider(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
            return sessionFactory;
        }
            return sessionFactory;
    }
}
