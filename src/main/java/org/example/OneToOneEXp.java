package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneEXp {
    private static SessionFactory sessionFactory;
    static{
        //Step: load configuration
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Step:  build a session factory
         sessionFactory=configuration.buildSessionFactory();

    }

    public static void addaudi()
    {
        Session session=sessionFactory.openSession();

        //Step: begin transaction
        Transaction transaction = session.beginTransaction();

        Auditorium auditorium1=new Auditorium();
        AudiAddress audiAddress1=new AudiAddress();

        auditorium1.setName("Auditorium 2");
        auditorium1.setAudiSeatColumns(30);
        auditorium1.setAudiSeatColumns(5);

        audiAddress1.setStreetName("Street 2");
        audiAddress1.setArea("HSR");
        audiAddress1.setCity("BLR");
        audiAddress1.setPincode(560042);

        //linking audi to audi_address
        auditorium1.setAudiaddress(audiAddress1);
        session.persist(auditorium1);

        //Step: commit transaction
        transaction.commit();

        //Step: close the session
        session.close();

    }
    public static void getAudiDetails()
    {
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        Auditorium a1=session.find(Auditorium.class,2);

        System.out.println();

        System.out.println("================================audi details================");
        System.out.println("ID              :"+a1.getId());
        System.out.println("Name            :"+a1.getName());
        System.out.println("seat rows       :"+a1.getAudiSeatRows());
        System.out.println("seat columns    :"+a1.getAudiSeatColumns());


        System.out.println("street           :"+a1.getAudiaddress().getStreetName());
        System.out.println("Area             :"+a1.getAudiaddress().getArea());
        System.out.println("City             :"+a1.getAudiaddress().getCity());
        System.out.println("Pincode          :"+a1.getAudiaddress().getPincode());


        //Step: commit transaction
        transaction.commit();

        //Step: close the session
        session.close();
    }

    public static  void   displayAudiAddress()
    {
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        AudiAddress audiAddress1=session.find(AudiAddress.class,2);

        System.out.println("================================AUDI ADDRESS================");

        System.out.println();
        System.out.println("Id               :"+audiAddress1.getId());
        System.out.println("street           :"+audiAddress1.getStreetName());
        System.out.println("City             :"+audiAddress1.getCity());
        System.out.println("Pincode          :"+audiAddress1.getPincode());
        System.out.println("Area             :"+audiAddress1.getArea());
        System.out.println();
        System.out.println("================================AUDI ADDRESS================");

        System.out.println();

        System.out.println("================================AUDI DETAILS================");
        System.out.println();
        System.out.println("ID              :"+audiAddress1.getAuditorium().getId());
        System.out.println("Name            :"+audiAddress1.getAuditorium().getName());
        System.out.println("seat rows       :"+audiAddress1.getAuditorium().getAudiSeatRows());
        System.out.println("seat columns    :"+audiAddress1.getAuditorium().getAudiSeatColumns());
        System.out.println();
        System.out.println("================================AUDI DETAILS================");
    }


    public static void main(String[] args) {
        //addaudi();
      // getAudiDetails();
        displayAudiAddress();
       sessionFactory.close();
    }
}










