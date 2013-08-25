package com.ganesh.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

    // Criteria is the where clause substitution of hibernate
    Criteria criteria = session.createCriteria(UserDetails.class);

    // criteria.add(Restrictions.eq("userName", "User4"));
    // criteria.add(Restrictions.or(Restrictions.eq("userName", "User1"), Restrictions.eq("userName", "User2")));
    // criteria.add(Restrictions.like("userName", "%User1%")).add(Restrictions.between("userName", "User1", "User9"));
    //
    // List<UserDetails> users = criteria.list();
    //
    // for (UserDetails user : users) {
    // System.out.println(user.getUserName());
    // }
    

    // Projections are related to columns
    //    criteria.add(Restrictions.between("userId", 5, 9));
    //    criteria.setProjection(Projections.property("userName")).addOrder(Order.desc("userId"));
    //
    //    List<String> users = criteria.list();
    //    for (String user : users) {
    //      System.out.println(user);
    //    }

    
    UserDetails userDetails = new UserDetails();
    userDetails.setUserId(4);
    userDetails.setUserName("User%");
    
    //Alternative for multiple Restrictions & Projections
    Example example = Example.create(userDetails).enableLike();//.excludeProperty(name);
    criteria.add(example);
    
    List<UserDetails> users = criteria.list();

    for (UserDetails user : users) {
      System.out.println(user.getUserName());
    }
    
    tx.commit();

  }
}
