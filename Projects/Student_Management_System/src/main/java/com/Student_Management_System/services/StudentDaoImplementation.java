package com.Student_Management_System.services;

import com.Student_Management_System.entities.Student;
import com.Student_Management_System.utils.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


/**
 * @author Zulfa Attar
 */
public class StudentDaoImplementation implements StudentDao{

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

        List<Student> studentList = session.createQuery("from student").list();

        return studentList;
    }

    @Override
    public int updateStudent(Student student) {

    }
}
