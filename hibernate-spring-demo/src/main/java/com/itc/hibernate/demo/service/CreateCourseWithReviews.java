package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Course;
import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import com.itc.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCourseWithReviews {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, Course.class, Review.class, InstructorDetail.class);
        SessionFactory factory = manager.factory;
        Session session = manager.session;
        try{
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            Course course = new Course("Kalimba essentials");
            course.addReview(new Review("Awesome sweet melodies! thx"));
            instructor.addCourse(course);
            session.save(course);
            session.getTransaction().commit();
        }
        finally {
            manager.closeSectionAndFactory();
        }
    }
}
