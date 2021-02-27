package com.example.keanchin.exception;

import java.util.Random;

public class CarRentalUtil {
    private static char[] alphaNumeric = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String generateRandomAlphaNumeric(int num) {
        Random rand = new Random();
        String pwd = "";

        for(int i = 0; i < num; ++i) {
            pwd = pwd + alphaNumeric[rand.nextInt(alphaNumeric.length)];
        }

        return pwd;
    }

}
