package com.application_demo.springmvc_custom_authentication.functions;

import java.util.UUID;


public class Token {

    // Generate Random String Token Method:
    public static String generateToken(){
         String randomTokenString = UUID.randomUUID().toString();
         return randomTokenString;
    }
    // End Of Generate Random String Token Method.

}
