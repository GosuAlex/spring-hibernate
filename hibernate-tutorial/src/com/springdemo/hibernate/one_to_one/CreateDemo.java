package com.springdemo.hibernate.one_to_one;

import com.springdemo.hibernate.one_to_one.entity.Instructor;
import com.springdemo.hibernate.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
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

        } finally {
            factory.close();
        }
    }
}
