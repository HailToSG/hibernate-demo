package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Course;
import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class);

        try (SessionFactory factory = manager.factory; Session session = manager.session){
            Instructor tempInstructor = new Instructor("Leo", "Max", "Leo.Max@gmail.com");
            InstructorDetail tempDetails = new InstructorDetail("rutube.com", "make vider");
            Course course = new Course("Love2CodeYoYo");
            tempInstructor.setInstructorDetail(tempDetails);
            tempInstructor.addCourse(course);

            session.beginTransaction();
            session.save(course);
            session.save(tempInstructor);
            session.getTransaction().commit();
        }
    }
}
