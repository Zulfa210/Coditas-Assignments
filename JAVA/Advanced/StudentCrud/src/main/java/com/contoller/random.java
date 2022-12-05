package com.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Zulfa Attar
 */
public class random {
    public static void main(String[] args) {
        Random random = new Random();

        String s = "";
        for(int i = 0; i<12; i++){
            s = s+Integer.toString(random.nextInt(10));
        }
        long x = Long.parseLong(s);
        //System.out.println(x);

        double a =  (10/0.0);
        System.out.println(x);

        List<Integer> list = new ArrayList<>();
    }
}
