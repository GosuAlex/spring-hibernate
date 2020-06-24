package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {

        // load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean from spring container
        Coach theCouch = context.getBean("myCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCouch.getDailyWorkout());
        System.out.println(theCouch.getDailyFortunes());


        System.out.println("--- first bean done ---");

        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortunes());
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());

        // close context
        context.close();
    }
}
