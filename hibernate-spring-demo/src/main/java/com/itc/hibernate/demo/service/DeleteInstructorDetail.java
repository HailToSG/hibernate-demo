package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteInstructorDetail {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class);
        try (SessionFactory factory = manager.factory; Session session = manager.session) {
            session.beginTransaction();
            InstructorDetail details = session.get(InstructorDetail.class, 1);
            Instructor instructor;
            if (details != null) {
                instructor = details.getInstructor();

                System.out.println(details);
                System.out.println("and Instructor for it");
                System.out.println(instructor);


                System.out.println("Delete details of instructor "
                        + instructor.getFirstName()
                        + " " + instructor.getLastName());
                instructor.setInstructorDetail(null);
                session.delete(details);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
