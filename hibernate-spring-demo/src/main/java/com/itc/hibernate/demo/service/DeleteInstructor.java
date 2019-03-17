package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor tempInstructor = session.get(Instructor.class, 6753);
            InstructorDetail tempDetails = tempInstructor.getInstructorDetail();
            System.out.println(tempInstructor);
            System.out.println(tempDetails);


                System.out.println("Delete instructor"
                        + tempInstructor.getFirstName()
                        + " " + tempInstructor.getLastName());
                session.delete(tempInstructor);

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
