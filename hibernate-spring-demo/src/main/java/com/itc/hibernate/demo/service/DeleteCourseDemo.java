package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Course;
import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import com.itc.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class, Course.class, Review.class);

        try (SessionFactory factory = manager.factory; Session session = manager.session){


            session.beginTransaction();

            Course course = session.get(Instructor.class, 2).getCourses().get(0);
            session.delete(course);
            session.getTransaction().commit();
        }
    }
}
