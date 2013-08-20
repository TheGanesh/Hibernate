package com.ganesh.hibernate.cascade;

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

    Vehicle vehicle2 = new Vehicle();
    vehicle2.setVehicleName("Honda civic");

    userDetails.getVehicles().add(vehicle);
    userDetails.getVehicles().add(vehicle2);

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    //.persist almost equal to save but enables this cascade operation
    session.persist(userDetails);

    // These are not required if annotated with @Cascade
    // session.save(vehicle);
    // session.save(vehicle2);

    tx.commit();

  }
}
