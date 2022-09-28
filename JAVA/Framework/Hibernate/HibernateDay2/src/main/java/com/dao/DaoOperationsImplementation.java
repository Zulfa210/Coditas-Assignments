package com.dao;

import com.bean.Book;

import com.mysql.cj.QueryResult;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public void fetchByRestriction(String authorName) {
        Session session = configuration.buildSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);

        criteria.add(Restrictions.like("authorName",authorName));

        List<Book> list = (List) criteria.list();
        for(Book book1: list){
            System.out.println(book1);
        }
    }

    @Override
    public void fetchByOrder(String order, String propertyName) {
        Session session = configuration.buildSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);

        if(order.equalsIgnoreCase("asc")){
            criteria.addOrder(Order.asc(propertyName));
        }else{
            criteria.addOrder(Order.desc(propertyName));
        }
        List<Book> list = criteria.list();
        for(Book book: list){
            System.out.println(book);
        }
    }

    @Override
    public void fetchByProjection(String propertyName) {

        Session session = configuration.buildSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        Projection projection = Projections.property(propertyName);

        criteria.setProjection(projection);
        List list = criteria.list();
        for(Object book: list){
            System.out.println(book);
        }

    }
}
