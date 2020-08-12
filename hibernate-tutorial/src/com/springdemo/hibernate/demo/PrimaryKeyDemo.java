package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating student");
            Student tempStudent1 = new Student("test1", "1", "test@test.com");
            Student tempStudent2 = new Student("test2", "2", "test@test.com");
            Student tempStudent3 = new Student("test3", "3", "test@test.com");

            session.beginTransaction();

            System.out.println("saving student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
