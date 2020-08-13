package com.springdemo.hibernate.one_to_many;

import com.springdemo.hibernate.one_to_many.entity.Course;
import com.springdemo.hibernate.one_to_many.entity.Instructor;
import com.springdemo.hibernate.one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor tempInstructor = new Instructor("john", "doe", "darby@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.luv2code.com/youtube", "luv 2 johndoe!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            session.save(tempInstructor);

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
