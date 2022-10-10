package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Zulfa Attar
 */
public class MainApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Director director = new Director();
        director.setDirectorId(101);
        director.setDirectorName("Remo");

        Movie movie;
        Set<Movie> movies = new HashSet<>();
        movie  = new Movie(1, "ABCD");
        session.save(movie);
        movies.add(movie);
        movie = new Movie(2, "ABCD2");
        session.save(movie);
        movies.add(movie);
        movie = new Movie(3, "Street Dancer");
        session.save(movie);
        movies.add(movie);

        director.setMovies(movies);

//        Director director1 = new Director();
//        director1.setDirectorId(102);
//        director1.setDirectorName("Yash Chopra");
//
//        Set<Movie> movieSet = new HashSet<>();
//        movieSet.add(new Movie(1, "Dhoom"));
//        movieSet.add(new Movie(2, "Dhoom2"));
//        movieSet.add(new Movie(3, "Dhoom2"));
//
//        director1.setMovies(movieSet);


        int i = (int)session.save(director);
       // int j = (int) session.save(director1);


        if(i>0){
            transaction.commit();
            System.out.println("Added Successfully");
        }

    }
}
