package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Course;
import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class, Course.class);

        try (SessionFactory factory = manager.factory; Session session = manager.session){
            Instructor tempInstructor = new Instructor("s", "fse", "fgdd");
            InstructorDetail tempDetails = new InstructorDetail("fs", "nfsdf");
            Course course = new Course("daw2");
            tempInstructor.setInstructorDetail(tempDetails);
            tempInstructor.addCourse(course);

            session.beginTransaction();
            session.save(tempInstructor);
            session.save(course);
            session.getTransaction().commit();
        }
    }
}
