package com.ganesh.hibernate.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    UserDetails userDetails = new UserDetails();
    userDetails.setUserName("Ganesh");

    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleName("Toyota corolla");

    userDetails.setVehicle(vehicle);

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(userDetails);
    session.save(vehicle);

    tx.commit();

  }
}
