package com.bean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {

        Session session= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee(1, "Zulfa");
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(2,"Abhishek", 1000, 12);
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(3, "Dev", 25000, 30, 1220);

        session.save(employee);
        session.save(partTimeEmployee);
        session.save(fullTimeEmployee);

        transaction.commit();

    }
}
