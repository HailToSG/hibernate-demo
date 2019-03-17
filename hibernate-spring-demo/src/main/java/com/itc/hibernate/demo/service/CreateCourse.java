package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourse {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class);
        SessionFactory factory = manager.factory;
        Session session = manager.session;
        try{
            session.beginTransaction();
            session.getTransaction().commit();
        }
        finally {
            manager.closeSectionAndFactory();
        }
    }
}
