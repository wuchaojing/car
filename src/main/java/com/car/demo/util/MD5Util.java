package com.car.demo.util;

import java.security.MessageDigest;

/*
 * give string encryption
 */
public class MD5Util {

    public static String str2MD5(String strs) {
        /*
         * encryption need jdk's class
         */
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(strs.getBytes());
            /*
             * after encryption is -128 to 127 ,is not safe
             * use it to binary operation,get new encryption result
             *
             *  0000 0011 0000 0100 0010 0000 0110 0001
             * &0000 0000 0000 0000 0000 0000 1111 1111
             * ---------------------------------------------
             *  0000 0000 0000 0000 0000 0000 0110 0001
             *
             *  change to 16 bit
             */
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if (x < 16) {
                    sb.append("0");
                }
                sb.append(s);
            }

        } catch (Exception e) {
            System.out.println("encryption lose");
        }
        return sb.toString();
    }

}
