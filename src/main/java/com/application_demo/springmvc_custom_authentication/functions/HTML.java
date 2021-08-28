package com.application_demo.springmvc_custom_authentication.functions;

public class HTML {

    public static String emailHtmlBody(String token, String email){
        String url = "http://127.0.0.1:8070/verify_account?verification_token=" +token + "&email="+email;

        String emailBody = "<h1>Verify Account</h1><br/>"+
                "<p>You have been successfully registered on to the system </p></br/>"+
                "<p>Please Click the link below to verify your account</p></br/>"+
                "<a href='"+url+"'>Verify Account</a>";
        return emailBody;
    }
}
