package com.wickedwitch.merkle_tree;

import sun.plugin2.message.Message;

import java.security.MessageDigest;


public class SHA256Hepler {

    public static String hash(String dateToHash) {

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(dateToHash.getBytes("UTF-8"));

            StringBuffer hexadecimalSB = new StringBuffer();

            for(int i = 0; i < hash.length; i++){
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if (hexadecimal.length() == 1){hexadecimalSB.append('0');
                }
                hexadecimalSB.append(hexadecimal);
            }

            return hexadecimalSB.toString();

        } catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }
}
