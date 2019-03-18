package com.itc.hibernate.demo.service;

import com.itc.hibernate.demo.entity.Course;
import com.itc.hibernate.demo.entity.Instructor;
import com.itc.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager("hibernate.cfg.xml",
                Instructor.class, InstructorDetail.class, Course.class);

        try (SessionFactory factory = manager.factory; Session session = manager.session){
            Instructor instructor;

            session.beginTransaction();
            instructor  = session.get(Instructor.class, 1);
            List<Course> allInstructorCourses = instructor.getCourses();
            for (Course course : (allInstructorCourses)) {
                System.out.println(course);
            }
            session.getTransaction().commit();
        }
    }
}
