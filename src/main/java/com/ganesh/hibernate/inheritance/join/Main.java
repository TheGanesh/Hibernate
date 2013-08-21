package com.ganesh.hibernate.inheritance.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ganesh.hibernate.commons.Singletons;

public class Main {

  public static void main(String[] args) {

    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleName("Basic Vehicle");

    TwoWheeler bike = new TwoWheeler();
    bike.setVehicleName("Hero Honda");
    bike.setSteeringHandle("Steering ahndle");

    FourWheeler car = new FourWheeler();
    car.setVehicleName("Toyota Corolla");
    car.setSteeringWheel("Steering wheel");

    SessionFactory sessionFactory = Singletons.getSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();

    session.save(vehicle);
    session.save(bike);
    session.save(car);
    tx.commit();

  }
}
