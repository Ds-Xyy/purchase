package com.turing.purchase.Untils;

import java.util.Random;

public class SaltUtils {

    public static Random r = new Random();

    public static String getSalt(int count){

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890~!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<count;i++){
            char c=chars[r.nextInt(chars.length)];
            sb.append(c);
        }

        return  sb.toString();
    }
}
