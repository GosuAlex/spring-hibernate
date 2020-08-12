package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating student");
            Student tempStudent = new Student("roy", "doe", "test@test.com");

            session.beginTransaction();

            System.out.println("saving student");
            session.save(tempStudent);

            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
