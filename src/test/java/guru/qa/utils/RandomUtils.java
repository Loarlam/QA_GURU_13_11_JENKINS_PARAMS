package guru.qa.utils;

import guru.qa.enumvalues.States;

import java.util.Random;

public class RandomUtils {

    Random random = new Random();

    public String selectingState() {
        return States.values()[random.nextInt(States.values().length)].getName();
    }

    public String selectingCities(String userCity) {
        String[] FromNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] FromUttar = {"Agra", "Lucknow", "Merrut"};
        String[] FromHaryana = {"Karnal", "Panipat"};
        String[] FromRajasthan = {"Jaipur", "Jaiselmer"};

        String resultOfCities = null;

        switch (userCity) {
            case "NCR":
                resultOfCities = FromNCR[random.nextInt(FromNCR.length)];
                break;
            case "Uttar Pradesh":
                resultOfCities = FromUttar[random.nextInt(FromUttar.length)];
                break;
            case "Haryana":
                resultOfCities = FromHaryana[random.nextInt(FromHaryana.length)];
                break;
            case "Rajasthan":
                resultOfCities = FromRajasthan[random.nextInt(FromRajasthan.length)];
                break;
        }
        return resultOfCities;
    }
}



