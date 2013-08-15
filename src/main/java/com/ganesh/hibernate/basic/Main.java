package com.ganesh.hibernate.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    Address homeAddress = new Address();
    homeAddress.setCity("Richfield");
    homeAddress.setStreet("Knox Ave");
    homeAddress.setPin(55423);

    userDetails.setHomeAddress(homeAddress);
    
    Address officeAddress = new Address();
    officeAddress.setCity("Richfield");
    officeAddress.setStreet("Penn Ave");
    officeAddress.setPin(55423);
    
    userDetails.setOfficeAddress(officeAddress);
     
    List<Address> listOfAddresses = new ArrayList<Address>();
    listOfAddresses.add(homeAddress);
    listOfAddresses.add(officeAddress);
    userDetails.setListOfAddresses(listOfAddresses);
    
    
    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(userDetails);

    tx.commit();

    session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    UserDetails user1 = (UserDetails) session.get(UserDetails.class, 1);
    session.close();
    System.out.println(user1.getUserName());
   List<Address> addreses = (List<Address>) user1.getListOfAddresses();
   System.out.println(addreses.get(0).getStreet());

  }
}
