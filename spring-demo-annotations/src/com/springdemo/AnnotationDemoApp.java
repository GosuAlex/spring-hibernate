package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call method on bean
        System.out.println(theCoach.getDailyWorkout());

        // call daily fortune method
        System.out.println(theCoach.getDailyFortune());

        // close context
        context.close();
    }
}
