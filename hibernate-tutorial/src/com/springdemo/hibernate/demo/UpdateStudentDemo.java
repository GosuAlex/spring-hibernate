package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session.beginTransaction();

            System.out.println("getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("updating students");
            myStudent.setFirstName("newName");

            session.getTransaction().commit();

            // next thing

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("update email on all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
