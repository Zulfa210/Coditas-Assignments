package com.bean;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        Session session = configuration.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter Student Name: ");
            Student student = new Student();
            student.setStudentName(bufferedReader.readLine());

            System.out.println("Enter Teacher Name: ");
            Teacher teacher = new Teacher();
            teacher.setTeacherName(bufferedReader.readLine());

            student.setTeacher(teacher);
            teacher.setStudent(student);

            session.save(teacher);
            session.save(student);

            transaction.commit();

            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
