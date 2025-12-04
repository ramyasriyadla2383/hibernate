package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("program starts");

        //Step: load configuration
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Step:  build a session factory
        SessionFactory sessionFactory=configuration.buildSessionFactory();

        //Step: open session
        Session session=sessionFactory.openSession();

        //Step: begin transaction
        Transaction transaction = session.beginTransaction();

//        String selectMovieByStatus_HQL= "FROM Movie m WHERE m.status='AVAILABLE'";
//        Query<Movie> query = session.createQuery(selectMovieByStatus_HQL, Movie.class);
//        List<Movie> resultList = query.getResultList();
//
//        for(Movie movie:resultList){
//            System.out.println(movie);
//        }

        String selectMovieByStatus_HQL2= "FROM Movie m WHERE m.status=:status";
        Query<Movie> query2 = session.createQuery(selectMovieByStatus_HQL2, Movie.class);
        System.out.println("enter  movie status to search");
        String status=scanner.next();
        query2.setParameter("status",MovieStatus.valueOf(status));

        List<Movie> resultList2 = query2.getResultList();

        for(Movie movie:resultList2){
            System.out.println(movie);
        }



        session.close();
        sessionFactory.close();
        System.out.println("program ends");
    }
}
