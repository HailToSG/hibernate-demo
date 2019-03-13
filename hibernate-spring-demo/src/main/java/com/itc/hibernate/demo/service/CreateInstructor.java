package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor = new Instructor("Paul", "Romero", "paul.romero@gmail.com");
            InstructorDetail tempDetails = new InstructorDetail("www.youtube.com/PAULanthonyROMERO", "Athletics");
            tempInstructor.setInstructorDetail(tempDetails);

                    session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
