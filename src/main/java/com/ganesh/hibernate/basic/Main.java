package com.ganesh.hibernate.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ganesh.hibernate.commons.Singletons;

public class Main {
  
  public static void main(String[] args) {

    UserDetails userDetails = new UserDetails();
    userDetails.setUserId(1);
    userDetails.setUserName("Ganesh");
    
    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    
    session.save(userDetails);
    
    session.getTransaction().commit();
    
    
  }
}
