package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // get bean from spring container
        Coach theCouch = context.getBean("myCoach", Coach.class);

        Coach alphaCouch = context.getBean("myCoach", Coach.class);

        // check if they are the same
        boolean result = (theCouch == alphaCouch);
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCouch: " + theCouch);
        System.out.println("\nMemory location for alphaCouch: " + alphaCouch + "\n");

        context.close();
    }
}
