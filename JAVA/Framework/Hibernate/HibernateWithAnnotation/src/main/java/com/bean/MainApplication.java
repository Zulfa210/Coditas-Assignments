package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.Query;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Teacher name, designation, city, salary, contact no.: ");
            Teacher teacher = new Teacher();

//            teacher.setTeacherName(bufferedReader.readLine());
//            teacher.setTeacherDesignation(bufferedReader.readLine());
//            teacher.setTeacherCity(bufferedReader.readLine());
//            teacher.setTeacherSalary(Float.parseFloat(bufferedReader.readLine()));
//            teacher.setTeacherContactNo(bufferedReader.readLine());

            Configuration configuration = new Configuration();

            configuration.configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            //int success = (int) session.save(teacher);

//            if (success >0){
//                System.out.println("Added Successfully");
//                transaction.commit();
//            }else {
//                System.out.println("Error");
//                transaction.rollback();
//            }

                    Query query = session.createQuery("from teacher_new");
            List<Teacher> li = query.list();


            for (Teacher t: li){
                System.out.println(t);
            }
        }catch (Exception e){

        }
    }
}
