package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class LoginHQL {
    public static void login(String username, String password) {
        System.out.println("program starts");

        //Step: load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Step:  build a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Step: open session
        Session session = sessionFactory.openSession();

        //Step: begin transaction
        Transaction transaction = session.beginTransaction();


        String selectHQL = "FROM UsersData user WHERE user.name=:username AND user.password=:password";
        Query<UsersData> query = session.createQuery(selectHQL, UsersData.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        UsersData usersData = query.uniqueResult();
        if(usersData != null) {
            System.out.println("login successfull");
        }
        else {
            System.out.println("login failed");
        }


        session.close();
        sessionFactory.close();
        System.out.println("program ends");

    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter username:");
        String username=s.nextLine();
        System.out.println("Enter password:");
        String password=s.nextLine();
        login(username,password);

    }
}
