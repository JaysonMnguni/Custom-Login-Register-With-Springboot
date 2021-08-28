package com.application_demo.springmvc_custom_authentication.controllers;

import com.application_demo.springmvc_custom_authentication.dao.ApplicationDAO;
import com.application_demo.springmvc_custom_authentication.functions.HTML;
import com.application_demo.springmvc_custom_authentication.functions.Hash;
import com.application_demo.springmvc_custom_authentication.functions.Token;
import com.application_demo.springmvc_custom_authentication.messenger.MailMessenger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

@Controller
public class indexController {

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView indexView = new ModelAndView("index");
        indexView.addObject("PageTitle", "Home");
        System.out.println("In Index Controller / Page");
        return indexView;
    }
    // End Of Main / Home Page View Method.

    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView errorView = new ModelAndView("error");
        errorView.addObject("PageTitle", "Error");
        System.out.println("In Error Controller / Page");
        return errorView;
    }
    // End of Error view Method.

    @GetMapping("/account_de_activated")
    public ModelAndView getAccountDeActivated(){
        ModelAndView accountDeActivatedView = new ModelAndView("account_de_activated");
        accountDeActivatedView.addObject("PageTitle", "Account De-Activated");
        System.out.println("In Accounts De-Activated Controller / Page");
        return accountDeActivatedView;
    }
    // End Of Account De-Activated View Method.


    @PostMapping("/account_de_activated")
    public ModelAndView accountReActivate(@RequestParam("email") String email){
        System.out.println("In Accounts De-Activated Post Controller / Page");
        // Get Token:
        String token = Token.generateToken();

        // Set Verification Token:
        if(!ApplicationDAO.setVerificationToken(email, token)){
            ModelAndView errorView = new ModelAndView("error");
            errorView.addObject("baseError", "Something went wrong please contact Administrator");
            return errorView;
        }
        // End Of Set Verification Token.

        // Send User Notification Try Block:
        try{
            // Get URL / Query String:
            String emailBody = HTML.emailHtmlBody(token, email);
            // Send Email:
            MailMessenger.htmlEmailMessenger("support@somecompany.co.za", email, "Activate Your Account", emailBody );
        }catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed To Send Email Message.");
        }
        // End Of Send User Notification Try Block.

        ModelAndView successView = new ModelAndView("success");
        successView.addObject("PageTitle", "Success");
        successView.addObject("success", "Form submitted successfully!");
        return successView;
    }
    // End Of Account De-Activated View Method.


    @GetMapping("/verify_account")
    public ModelAndView getVerifyAccount(@RequestParam("verification_token") String token, @RequestParam("email") String email){
        // Verify Account:
        if(!ApplicationDAO.verifyToken(email, token)){
            ModelAndView errorView = new ModelAndView("error");
            errorView.addObject("PageTitle", "Error");
            errorView.addObject("sessionExpired", "This Session Has Expired!");
            return errorView;
        }

        ModelAndView verifyAccountView = new ModelAndView("account_verification");
        verifyAccountView.addObject("PageTitle", "Verify Account");
        System.out.println("In Verify Account Controller / Page");
        return verifyAccountView;
    }
    // End Of Verify Account View Method.


    @PostMapping("/verify_account")
    public ModelAndView verifyAccount(@RequestParam("verification_token") String token,
                                      @RequestParam("email") String email,
                                      @RequestParam("password")String password,
                                      @RequestParam("confirm_password") String confirm_password){

        // Check If Passwords Match:
        if(!password.equals(confirm_password)){
            ModelAndView verifyAccountView = new ModelAndView("account_verification");
            verifyAccountView.addObject("PageTitle", "Verify Account");
            verifyAccountView.addObject("passwordsDontMatch", "Passwords do not match!");
            return verifyAccountView;
        }
        // End Of Check If Passwords Match.

        // Hash Password:
        String hashedPassword = Hash.passwordHash(password);

        // Verify Account:
        if(!ApplicationDAO.verifyAccount(hashedPassword, email, token)){
            ModelAndView errorView = new ModelAndView("error");
            errorView.addObject("PageTitle", "Error");
            errorView.addObject("verifyError", "Error Verifying account, please contact your administrator");
            return errorView;
        }
        // End Of Verify Account.

        ModelAndView successView = new ModelAndView("success");
        successView.addObject("PageTitle", "Success");
        successView.addObject("success", "Account Successfully Verified, Please proceed to login");
        System.out.println("In Verify Account Controller / Page");
        return successView;
    }
    // End Of Verify Account View Method.
    

}
