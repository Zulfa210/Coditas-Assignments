package com.bean;

import net.sf.ehcache.hibernate.EhCacheRegionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * @author Zulfa Attar
 */
public class MainApplication {

    public void firstLevelCache(){
        Employee employee = new Employee(1, "Zulfa", "Pune");
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction  transaction = session.beginTransaction();

        session.save(employee);
        transaction.commit();


        Employee employee1 = session.get(Employee.class, 1);
        System.out.println(employee1);
        Employee employee2 = session.get(Employee.class, 1);
        System.out.println(employee2);
        session.clear();

        //Session session1 = sessionFactory.openSession();
        Employee employee3 = session.get(Employee.class, 1);
        System.out.println(employee3);
        session.close();


    }

    public void secondLevelCache(){

        Employee employee = new Employee(2, "Dev", "Bhopal");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
//        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties())
//                .build();
//
//        Metadata meta=new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//
//        SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);

        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        System.out.println(session1.get(Employee.class, 2));
        System.out.println(session1.get(Employee.class, 1));
        session1.close();
        System.out.println(sessionFactory.getStatistics().getEntityFetchCount());           //Prints 1
        System.out.println(sessionFactory.getStatistics().getSecondLevelCacheHitCount());


    }
    public static void main(String[] args) {

        new MainApplication().secondLevelCache();


    }
}
