package com.springdemo.hibernate.demo;

import com.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            session.delete(myStudent);
            // or:
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            factory.close();
        }
    }
}
