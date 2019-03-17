package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class);

        try (SessionFactory factory = manager.factory; Session session = manager.session){
            Instructor tempInstructor = new Instructor("Leo2", "Max2", "Leo.Max@gmail.com");
            InstructorDetail tempDetails = new InstructorDetail("rutube.com", "make vider");
            tempInstructor.setInstructorDetail(tempDetails);

            session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();
        }
    }
}
