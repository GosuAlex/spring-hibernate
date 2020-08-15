package com.springdemo.hibernate.one_to_many_uni;

import com.springdemo.hibernate.one_to_many_uni.entity.Course;
import com.springdemo.hibernate.one_to_many_uni.entity.Instructor;
import com.springdemo.hibernate.one_to_many_uni.entity.InstructorDetail;
import com.springdemo.hibernate.one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

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
