package com.dao;

import com.bean.Book;

import com.mysql.cj.QueryResult;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Zulfa Attar
 */
public class DaoOperationsImplementation implements DaoOperations{

    static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

    @Override
    public void addBook(Book book) {

        Session session = configuration.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        int i = (int) session.save(book);
                if (i>0){
                    transaction.commit();
                    System.out.println("Record Added");
                }else {
                    System.out.println("Error");
                }

    }

    @Override
    public void displayAllBooks() {

        Session session = configuration.buildSessionFactory().openSession();
        List<Book> bookList=session.createQuery("from Book").list();
        for(Book book: bookList){
            System.out.println(book);
        }

    }

    @Override
    public void getByID(int id) {
        Session session = configuration.buildSessionFactory().openSession();
        System.out.println(session.get(Book.class,id));

    }

    @Override
    public void deleteBook(int id) {
        Session session = configuration.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Book where bookId = :id");
        query.setParameter("id", id);
        int i = query.executeUpdate();

        if(i>0){
            transaction.commit();
            System.out.println("Deleted Successfully");
        }
        else {
            System.out.println("error");
        }

    }

    @Override
    public void updateBook(int id, String bookName) {

        Session session = configuration.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Book set bookName =:name where bookId =:id");
        query.setParameter("name", bookName);
        query.setParameter("id", id);
        int i = query.executeUpdate();

        if(i>0){
            transaction.commit();
            System.out.println("Updated Successfully");
        }
        else {
            System.out.println("error");
        }
    }
}
