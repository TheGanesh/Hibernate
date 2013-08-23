package com.ganesh.hibernate.namedquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    // UserDetails userDetails = null;
    // for (int i = 1; i < 10; i++) {
    // userDetails = new UserDetails();
    // userDetails.setUserName("User" + i);
    // session.save(userDetails);
    // }

    //Query query = (Query) session.getNamedQuery("UserDetails.byId");
    Query query = (Query) session.getNamedQuery("USER_DETAILS.byId");
    query.setInteger("userId", 6);
    List<UserDetails> users = query.list();

    for (UserDetails user : users) {
      System.out.println(user.getUserName());
    }
    tx.commit();

  }
}
