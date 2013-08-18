package com.ganesh.hibernate.one2many;

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
    
    vehicle.setUser(userDetails);
    vehicle2.setUser(userDetails);

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(userDetails);
    session.save(vehicle);
    session.save(vehicle2);

    tx.commit();

  }
}
