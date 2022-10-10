package com.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zulfa Attar
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Zulfa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter no. of students: ");
        int noOfStudents = Integer.parseInt(bufferedReader.readLine());

        while (noOfStudents>0){
            Student student = new Student();
            System.out.println("Enter Student Name and Department: ");
            student.setStudentName(bufferedReader.readLine());
            student.setStudentDepartment(bufferedReader.readLine());

            entityManager.getTransaction().begin();

            entityManager.persist(student);
            entityManager.getTransaction().commit();

noOfStudents--;
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
