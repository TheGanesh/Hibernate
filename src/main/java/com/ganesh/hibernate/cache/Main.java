package com.ganesh.hibernate.cache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    UserDetails userDetails = new UserDetails();
    userDetails.setUserName("Ganesh");

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
//    session.save(userDetails);
//    tx.commit();
  
    //UserDetails user1 = (UserDetails) session.get(UserDetails.class, 1);
    Query query = session.createQuery("from UserDetails where userId = 1");
    query.setCacheable(true);
    List<UserDetails> list = query.list();
    
    session.close();

    Session session2 = sessionFactory.getCurrentSession();
    tx = session2.beginTransaction();
   
    //UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
    Query query2 = session2.createQuery("from UserDetails where userId = 1");
    query2.setCacheable(true);
    List<UserDetails> list2 = query2.list();
    
  }
}
