package com.springdemo.hibernate.one_to_many;

import com.springdemo.hibernate.one_to_many.entity.Course;
import com.springdemo.hibernate.one_to_many.entity.Instructor;
import com.springdemo.hibernate.one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

            System.out.println("done");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            factory.close();
        }
    }
}
