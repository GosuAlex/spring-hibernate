package com.springdemo.hibernate.one_to_one;

import com.springdemo.hibernate.one_to_one.entity.Instructor;
import com.springdemo.hibernate.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("found: " + tempInstructor);

            if(tempInstructor != null) session.delete(tempInstructor);

            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
