package com.application_demo.springmvc_custom_authentication.controllers;

import com.application_demo.springmvc_custom_authentication.dao.ApplicationDAO;
import com.application_demo.springmvc_custom_authentication.functions.HTML;
import com.application_demo.springmvc_custom_authentication.functions.Hash;
import com.application_demo.springmvc_custom_authentication.functions.Token;
import com.application_demo.springmvc_custom_authentication.messenger.MailMessenger;
import com.application_demo.springmvc_custom_authentication.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public ModelAndView getAdminDashboard(){
        // Init Model and View:
        ModelAndView adminDashboardView = new ModelAndView("admin/dashboard");
        adminDashboardView.addObject("PageTitle", "Admin Dashboard");
        System.out.println("In Admin Dashboard Controller / Page");
        return adminDashboardView;
    }

    @GetMapping("/add_user")
    public ModelAndView getAddUser(){
        // Init Model and View:
        ModelAndView addUserView = new ModelAndView("admin/add_users");
        addUserView.addObject("PageTitle", "Add User");
        System.out.println("In Admin Add User Controller / Page");
        return addUserView;
    }

    @PostMapping("/add_user")
    public ModelAndView addUser(@Valid @ModelAttribute("registerUser") User user, BindingResult result,
                                @RequestParam("first_name") String first_name,
                                @RequestParam("last_name") String last_name,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("confirm_password") String confirm_password,
                                @RequestParam("user_type") String user_type) throws SQLException {

        ModelAndView addUserView = new ModelAndView("admin/add_users");

        // Check For Errors:
        if(result.hasErrors()){
            return addUserView;
        }
        // End Of Check For Errors.

        // Check If Passwords Match:
        if(!password.equals(confirm_password)){
            addUserView.addObject("PasswordMisMatch","Passwords do not match!");
            return addUserView;
        }
        // End Of Check If Passwords Match.

        // Get Verification Token:
        String verification_token = Token.generateToken();

        // Hash Password:
        String hashed_password = Hash.passwordHash(password);

        // Register User:
        if(ApplicationDAO.registerUser(first_name, last_name, email,hashed_password, user_type, verification_token)){
            addUserView.addObject("RegistrationSuccess", "User Added Successfully");

            // Send User Notification Try Block:
            try{
                // Get URL / Query String:
               String emailBody = HTML.emailHtmlBody(verification_token, email);
               // Send Email:
                MailMessenger.htmlEmailMessenger("support@somecompany.co.za", email, "Verify Account", emailBody );
            }catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("Failed To Send Email Message.");
            }
            // End Of Send User Notification Try Block.
            return addUserView;
        }
        // End Of Register User.

        addUserView.addObject("RegisterError", "Something Went Wrong Contact Administrator!");
        return addUserView;

    }
}
