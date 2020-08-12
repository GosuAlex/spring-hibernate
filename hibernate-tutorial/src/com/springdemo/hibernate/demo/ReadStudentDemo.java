package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating student");
            Student tempStudent = new Student("testRead", "0", "test@test.com");

            session.beginTransaction();

            System.out.println("saving student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            session.getTransaction().commit();

            // new code

            System.out.println("saved student. Generated id " + tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("got student: " + myStudent.toString());

            session.getTransaction().commit();

            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
