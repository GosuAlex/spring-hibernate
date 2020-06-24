package com.springdemo;

public class BaseballCoach implements Coach {


    private FortuneService fortuneService;

    public BaseballCoach() {
    }

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 min on batting practice";
    }

    @Override
    public String getDailyFortunes() {
        // use my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
