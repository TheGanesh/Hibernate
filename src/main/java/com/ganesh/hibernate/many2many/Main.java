package com.ganesh.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    UserDetails userDetails = new UserDetails();
    userDetails.setUserName("Ganesh");

    UserDetails userDetails2 = new UserDetails();
    userDetails2.setUserName("Kumar");
    
    UserDetails userDetails3 = new UserDetails();
    userDetails3.setUserName("Kandisa");

    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleName("Toyota corolla");

    Vehicle vehicle2 = new Vehicle();
    vehicle2.setVehicleName("Honda civic");

    userDetails.getVehicles().add(vehicle);
    userDetails.getVehicles().add(vehicle2);
    
    vehicle.getUsersList().add(userDetails2);
    vehicle.getUsersList().add(userDetails3);

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(userDetails);
    session.save(userDetails2);
    session.save(vehicle);
    session.save(vehicle2);
    session.save(userDetails3);

    tx.commit();

    session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    UserDetails user1 = (UserDetails) session.get(UserDetails.class, 1);
    System.out.println("user1.getUserName():" + user1.getUserName());
    for (Vehicle v : user1.getVehicles()) {
      System.out.println("v.getVehicleName():" + v.getVehicleName());
    }

    Vehicle firstVehicle = (Vehicle) session.get(Vehicle.class, 1);
    System.out.println("firstVehicle.getVehicleName():" + firstVehicle.getVehicleName());
    for (UserDetails user : firstVehicle.getUsersList()) {
      System.out.println("user.getUserName():" + user.getUserName());
    }

  }
}
