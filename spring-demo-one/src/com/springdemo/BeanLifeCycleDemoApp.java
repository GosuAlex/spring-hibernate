package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // get bean from spring container
        Coach theCouch = context.getBean("myCoach", Coach.class);

        System.out.println(theCouch.getDailyWorkout());

        // close context
        context.close();
    }
}
