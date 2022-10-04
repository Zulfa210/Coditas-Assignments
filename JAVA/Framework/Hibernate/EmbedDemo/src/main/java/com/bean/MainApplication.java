package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        Student student = new Student();

        student.setStudentId(11);
        student.setStudentName("Zulfa");
        student.setContactNo("926785836");

        student.setAddress(new Address(101,"Golf Club Road", "Pune", 411006));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);

        transaction.commit();


        System.out.println(session.get(Student.class, 11));

        sessionFactory.close();
    }
}
