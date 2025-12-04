package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class OneToManydemo {
    static SessionFactory sessionFactory;
    static{
        //Step: load configuration
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Step:  build a session factory
         sessionFactory=configuration.buildSessionFactory();
    }
    public static  void addshows()
    {
        Session session=sessionFactory.openSession();

        //Step: begin transaction
        Transaction transaction = session.beginTransaction();

        System.out.println("audi object");
        Auditorium a1=new Auditorium();

        a1.setName("Audi-10");
        a1.setAudiSeatColumns(20);
        a1.setAudiSeatRows(5);

        System.out.println("creation show-1");
        Shows s1=new Shows();
        s1.setShowtime(LocalDate.now());
        s1.setEndTime(LocalDate.now());
        s1.setStatus("Available");


        System.out.println("creation show-2");
        Shows s2=new Shows();
        s2.setShowtime(LocalDate.now());
        s2.setEndTime(LocalDate.now());
        s2.setStatus("Available");

        //linking audi and shows
        System.out.println("linking audi and shows");
        a1.getShows().add(s1);
        a1.getShows().add(s2);


        System.out.println("save audi");
        session.persist(a1);




        transaction.commit();

        //Step: close the session
        session.close();

    }

    public static void getShowsByAudi(Long audiId)
    {

        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        System.out.println("Finding audi with id"+audiId);

        Auditorium auditorium=session.find(Auditorium.class,audiId);

        List<Shows> shows=auditorium.getShows();

        System.out.println("============================SHOW DETAILS===================");
        for(int i=0;i<shows.size();i++)
        {
            System.out.println();
            System.out.println(shows.get(i).getShowtime());
            System.out.println(shows.get(i).getEndTime());
            System.out.println(shows.get(i).getStatus());
            System.out.println();
        }

        System.out.println("============================SHOW DETAILS===================");
        transaction.commit();
        session.close();
    }

    public static void AddShowToExistingAudi(Long audiId)
    {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Shows show=new Shows();
        show.setShowtime(LocalDate.now());
        show.setEndTime(LocalDate.now());
        show.setStatus("Not Available");

        Auditorium auditorium=session.find(Auditorium.class,audiId);
        auditorium.getShows().add(show);
        session.persist(auditorium);
        transaction.commit();
        session.close();

    }
    public static void deleteshow(Long audiId,Long showId)
    {
        System.out.println("Deleting show with id"+showId);
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();


        Auditorium auditorium=session.find(Auditorium.class,audiId);
        List<Shows> shows=auditorium.getShows();
        for(int i=0;i<shows.size();i++)
        {
            if(shows.get(i).getId()==showId)
            {
                System.out.println("show found with id"+showId);
                shows.remove(i);


                break;
            }
        }
 session.merge(auditorium);
   transaction.commit();
        session.close();

    }
    public static void main(String[] args) {
        System.out.println("program starts");

       // getShowsByAudi(3l);

        //AddShowToExistingAudi(3l);
        //getShowsByAudi(3l);
        deleteshow(3l,4l);
        //Step: close the session factory
        sessionFactory.close();


        System.out.println("program ends");
    }
}
