package com.ganesh.hibernate.basic;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    UserDetails userDetails = new UserDetails();
    userDetails.setUserName("Ganesh");
    userDetails.setJoinedDate(new Date());
    userDetails.setPassword("password");
    userDetails.setBackground("Developer");

    Address address = new Address();
    address.setApt("12345");
    address.setStreet("Knox Ave");  

    userDetails.setAddress(address);
    
    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(userDetails);

    tx.commit();

    session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
    System.out.println(user2.getUserName());

  }
}
