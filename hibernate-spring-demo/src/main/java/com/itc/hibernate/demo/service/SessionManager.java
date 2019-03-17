package com.itc.hibernate.demo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    SessionManager(String hibernateConfigure, Class<?>...classes){
        Configuration  configuration = new Configuration().configure(hibernateConfigure);
        for (Class<?> annotatedClass : classes) {
            configuration.addAnnotatedClass(annotatedClass);
        }
        this.factory = configuration.buildSessionFactory();
        this.session = factory.getCurrentSession();
    }
    Session session;
    SessionFactory factory;
}
