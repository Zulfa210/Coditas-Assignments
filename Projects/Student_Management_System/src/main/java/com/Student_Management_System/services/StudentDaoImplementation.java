package com.Student_Management_System.services;

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
    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();
    @Override
    public void registerStudent(Student student) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();

    }

    @Override
    public void deleteStudent(int enrollmentId) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(Student.class, enrollmentId));
        transaction.commit();


    }

    @Override
    public List<Student> showAllStudents() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> studentList = session.createQuery("from Student").list();

        return studentList;
    }

    @Override
    public void updateStudent(Student student) {

        Session session = sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        session.saveOrUpdate(student);
        transaction.commit();

    }
}
