/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.dda.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author pvr
 */
public class RandomCodeGenerator {

    static String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz";
    static String RANDOM_STRING;

    public static String generateRandomCode(int PASSWORD_LENGTH) {
        try {

            Random random = new SecureRandom();
            RANDOM_STRING = "";
            for (int i = 0; i < PASSWORD_LENGTH; i++) {
                int index = (int) (random.nextDouble() * ALPHA_NUMERIC_STRING.length());
                System.out.println("index = " + index);
                RANDOM_STRING += ALPHA_NUMERIC_STRING.substring(index, index + 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return RANDOM_STRING;
    }
    public static void main(String[] args) {
        System.out.println(generateRandomCode(6));
    }

}
