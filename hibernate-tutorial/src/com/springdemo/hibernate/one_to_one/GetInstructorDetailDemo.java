package com.springdemo.hibernate.one_to_one;

import com.springdemo.hibernate.one_to_one.entity.Instructor;
import com.springdemo.hibernate.one_to_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 2;
//            int theId = 2999;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor :" + tempInstructorDetail.getInstructor());

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
