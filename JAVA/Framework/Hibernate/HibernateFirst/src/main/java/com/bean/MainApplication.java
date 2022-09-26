package com.bean;

import com.fasterxml.classmate.AnnotationConfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        try{

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Book details: book name, author name, publisher Name and Price:");
            Book book = new Book();
            book.setBookName(bufferedReader.readLine());
            book.setAuthorName(bufferedReader.readLine());
            book.setPublisherName(bufferedReader.readLine());
            book.setPrice(Float.parseFloat(bufferedReader.readLine()));

            Configuration configuration = new Configuration();
            configuration.configure();

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            int l1 = (int)session.save(book);

            if(l1>0){
                transaction.commit();
                System.out.println("Record Added successfully");
            }else
                System.out.println("Try Again");

        }catch (Exception e){

        }
    }
}
