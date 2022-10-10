package com.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Zulfa Attar
 */
public class GetEntityManager {

    static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("Zulfa");
    }

    private GetEntityManager(){}

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
