package com.application_demo.springmvc_custom_authentication.functions;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Hash {

    // Hash Password Method:
    public static String passwordHash(String password){
        // Hash Password:
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    // End Of Hash Password Method.

    // Check / Compare Passwords:
    public static boolean verifyPasswords(String inputPassword, String hashedPassword){

        // Verify Passwords:
        if(BCrypt.checkpw(inputPassword, hashedPassword)){
            return true;
        }
        // End Of Verify Passwords.
        return false;
    }
    // End Of Check / Compare Passwords.
}
