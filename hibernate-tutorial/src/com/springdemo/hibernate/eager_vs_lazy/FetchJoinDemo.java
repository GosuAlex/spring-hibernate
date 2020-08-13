package com.springdemo.hibernate.eager_vs_lazy;

import com.springdemo.hibernate.eager_vs_lazy.entity.Course;
import com.springdemo.hibernate.eager_vs_lazy.entity.Instructor;
import com.springdemo.hibernate.eager_vs_lazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1;
            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id =:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("instructor: "+ tempInstructor);

            session.getTransaction().commit();

            session.close();
            System.out.println("Courses: " + tempInstructor.getCourses());

            System.out.println("done");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            factory.close();
        }
    }
}
