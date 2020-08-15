package com.springdemo.hibernate.one_to_many_uni;

import com.springdemo.hibernate.one_to_many_uni.entity.Course;
import com.springdemo.hibernate.one_to_many_uni.entity.Instructor;
import com.springdemo.hibernate.one_to_many_uni.entity.InstructorDetail;
import com.springdemo.hibernate.one_to_many_uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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

            Course tempCourse = new Course("eSports 101");

            tempCourse.addReview(new Review("Amazing!"));
            tempCourse.addReview(new Review("Great!"));
            tempCourse.addReview(new Review("Loved it!"));

            System.out.println("saving course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);

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
