package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneDemo {

    public static void main(String[] args) {
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

        Auditorium auditorium1=new Auditorium();
        AudiAddress audiAddress1=new AudiAddress();

        auditorium1.setName("Auditorium 1");
        auditorium1.setAudiSeatColumns(30);
        auditorium1.setAudiSeatColumns(5);

        audiAddress1.setStreetName("Street 1");
        audiAddress1.setArea("HBR");
        audiAddress1.setCity("BLR");
        audiAddress1.setPincode(560043);

        //linking audi to audi_address
        auditorium1.setAudiaddress(audiAddress1);

        session.persist(auditorium1);

        //Step: commit transaction
        transaction.commit();

        //Step: close the session
        session.close();

        //Step: close the session factory
        sessionFactory.close();




        System.out.println("program ends");

    }
}