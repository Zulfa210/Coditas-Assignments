package com.example.RestTest.service;

import com.example.RestTest.entities.Course;
import com.example.RestTest.entities.Teacher;
import com.example.RestTest.util.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zulfa Attar
 */

@Service
public class DaoOperationsImplementation implements DaoOperations{

//    SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

    public DaoOperationsImplementation() {
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(teacher);
        List<Course> courses = teacher.getCourses();
        for(Course course :courses){
            session.save(course);
        }
        transaction.commit();
    }

    @Override
    public List<Teacher> showTeachers() {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Teacher> teachers = session.createQuery("from Teacher").list();
       // System.out.println(teachers.get(0).getCourses());
        return teachers;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(session.get(Teacher.class, teacherId));
        transaction.commit();
    }

    @Override
    public void updateTeacher(Teacher teacher) {

        SessionFactory sessionFactory = GetSessionFactory.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Course> courses = teacher.getCourses();
        for(Course course :courses){
            session.saveOrUpdate(course);
        }
        session.saveOrUpdate(teacher);
        transaction.commit();
    }


}
