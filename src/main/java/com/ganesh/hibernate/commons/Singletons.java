package com.ganesh.hibernate.commons;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Singletons {

  private static SessionFactory sessionFactory;

  public static synchronized SessionFactory getSessionFactory() {

    if (sessionFactory == null) {
      Configuration configuration = new Configuration();
      configuration.configure();
      ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
    }

    return sessionFactory;
  }

}
