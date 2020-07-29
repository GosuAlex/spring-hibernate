package com.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortunes() {
        return fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartupStuff() {
        System.out.println("startup");
    }

    // add an destory method
    public void doMyCleanupStuff() {
        System.out.println("destroy/cleanup");
    }
}
