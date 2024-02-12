package com.example.authapp.util;
import java.security.SecureRandom;


public class GenerateCardNumber {
    private static final String DIGITS = "0123456789";
    private static SecureRandom random = new SecureRandom();
    public static String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(DIGITS.length());
            sb.append(DIGITS.charAt(randomIndex));
        }

        return sb.toString();
    }

}
