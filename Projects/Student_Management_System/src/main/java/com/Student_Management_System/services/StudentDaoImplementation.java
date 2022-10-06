package com.Student_Management_System.services;

import com.Student_Management_System.entities.Address;
import com.Student_Management_System.entities.Student;
import com.Student_Management_System.utils.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Zulfa Attar
 */

@Service
public class StudentDaoImplementation implements StudentDao{

    public StudentDaoImplementation() {}
    @Override
    public void registerStudent(Student student) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = student.getStudentTemporaryAddress();
        session.save(address);
        session.save(student);
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteStudent(int studentEnrollmentId) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentEnrollmentId);
        System.out.println(student);
        session.delete(student.getStudentTemporaryAddress());
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> showAllStudents() {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> studentList = session.createQuery("from Student").list();

        return studentList;
    }

    @Override
    public void updateStudent(Student student) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        session.saveOrUpdate(student.getStudentTemporaryAddress());
        session.saveOrUpdate(student);
        transaction.commit();
    }
}
