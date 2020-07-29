package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create array of strings
    private String[] data = {
            "random 1 string",
            "anotha string baby!",
            "yippie kay yay"
    };

    // crate random number gen
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        // return random string from array
        int index = myRandom.nextInt(data.length);

        return data[index];
    }
}
