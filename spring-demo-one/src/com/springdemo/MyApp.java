package com.springdemo;

public class MyApp {
    public static void main(String[] args) {

        // create object
        Coach theCouch = new BaseballCoach();

        // use object
        System.out.println(theCouch.getDailyWorkout());
    }
}
