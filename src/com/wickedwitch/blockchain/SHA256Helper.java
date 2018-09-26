package com.wickedwitch.blockchain;

import java.security.MessageDigest;

public class SHA256Helper {

    public static String generateHash(String toHash){

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toHash.getBytes("UTF-8"));

            //END result: hexadecimals not bytes
            StringBuffer hexadecimalStringBuffer = new StringBuffer();

            for(int i = 0; i < hash.length; i++){
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if (hexadecimal.length() == 1) {
                    hexadecimalStringBuffer.append('0');
                }
                    hexadecimalStringBuffer.append(hexadecimal);

            }


            return hexadecimalStringBuffer.toString();

        } catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

}
