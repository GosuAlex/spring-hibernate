package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);


            theStudents = session.createQuery("from Student s where s.lastName = 'hansen' or s.lastName = 'doe' ").getResultList();

            System.out.println("student with lastname hansen or doe :");
            displayStudents(theStudents);


            System.out.println("student with @gmail.com email :");
            theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
