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
    
    UserDetails userDetails2 = new UserDetails();
    userDetails2.setUserName("Kandisa");
    userDetails2.setJoinedDate(new Date());
    userDetails2.setPassword("password2");
    userDetails2.setBackground("Developer 2");
    
    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    
    session.save(userDetails);
    session.save(userDetails2);
    
    tx.commit();
    
    session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    UserDetails user2 = (UserDetails) session.get(UserDetails.class, 2);
    System.out.println(user2.getUserName());
   
    
  }
}
