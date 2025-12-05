package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {
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


        String selectUsersNyName_HQL= "FROM UsersData usr  WHERE usr.name='ramya'";
        Query<UsersData> query = session.createQuery(selectUsersNyName_HQL, UsersData.class);

        UsersData users = query.uniqueResult();
        System.out.println(users);


        session.close();
        sessionFactory.close();
        System.out.println("program ends....");
        System.out.println("======================================= hello everyone ===============================================");
    }
}
