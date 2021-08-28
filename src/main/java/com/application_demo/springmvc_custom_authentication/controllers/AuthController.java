package com.application_demo.springmvc_custom_authentication.controllers;

import com.application_demo.springmvc_custom_authentication.dao.ApplicationDAO;
import com.application_demo.springmvc_custom_authentication.functions.Hash;
import com.application_demo.springmvc_custom_authentication.functions.Token;
import com.application_demo.springmvc_custom_authentication.models.Login;
import com.application_demo.springmvc_custom_authentication.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class AuthController {

    // Get Login View Method:
    @GetMapping("/login")
    public ModelAndView getLogin(){
        String tokenFromController = Token.generateToken();
        ModelAndView loginView = new ModelAndView("login");
        loginView.addObject("PageTitle", "Login");
        loginView.addObject("tokenFromController",tokenFromController);
        System.out.println("In Login Controller / Page");
        return loginView;
    }
    // End Of Get Login View Method.


    // Login Post Method:
    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute("userLogin") Login login,
                              BindingResult result,
                              @RequestParam("email") String email,
                              @RequestParam("password")String password,
                              @RequestParam("_token") String token,
                              HttpSession session) throws SQLException {

        // Check Form Errors:
        if(result.hasErrors()){
            ModelAndView loginView = new ModelAndView("login");
            return loginView;
        }
        // End OF Check Form Errors.

        // Is Registered Email:
        if(!ApplicationDAO.isRegisteredEmail(email)){
            ModelAndView errorView = new ModelAndView("error");
            errorView.addObject("notRegistered", "There are not registered accounts with this email address, please contact your administrator!");
            return errorView;
        }
        // End Of Is Registered Email.


        // TODO: CHECK TO SEE IF THE USER ACCOUNT IS VERIFIED.
        if(!ApplicationDAO.isAccountVerified(email)){
            ModelAndView errorView = new ModelAndView("error");
            errorView.addObject("accountNotVerified", "This Account is not yet verified, please check your email and proceed with instruction");
            return errorView;
        }

        // TODO: CHECK TO SEE IF THE ACCOUNT IS ACTIVE.
        if(!ApplicationDAO.isAccountActive(email)){
            ModelAndView errorView = new ModelAndView("account_de_activated");
            return errorView;
        }

        // Get the hashed password:
        String DB_HashedPassword = ApplicationDAO.getStoredHashedUserPassword(email);

        // Validate User Password:
        if(!Hash.verifyPasswords(password, DB_HashedPassword)){
            ModelAndView loginView = new ModelAndView("login");
            loginView.addObject("incorrectDetails", "Incorrect Username or Password");
            return loginView;
        }
        // End Of Validate User Password.

        // Get The User Type:
        String userType = ApplicationDAO.getUserType(email);

        // Get User:
        User user = ApplicationDAO.getUser(email);

        // Set Session Attributes If No Errors:
        session.setAttribute("SessionToken", token);
        session.setAttribute("user", user);

        // Check User Type and Redirect Users:
        switch(userType){
            case "admin":
                ModelAndView adminView = new ModelAndView("admin/dashboard");
                return adminView;
            case "user":
                ModelAndView userView = new ModelAndView("users/dashboard");
                return userView;
            default:
                ModelAndView errorView = new ModelAndView("error");
                errorView.addObject("loginError", "Something Went Wrong Contact Administrator!");
                return errorView;
        }
        // End Of Check User Type and Redirect Users.

    }
    // End Of Login Post Method.


    @GetMapping("/logout")
    public ModelAndView getLogout(HttpSession session){
        session.invalidate();
        System.out.println("Session has ended!");
        ModelAndView loginView = new ModelAndView("login");
        loginView.addObject("logoutSuccess", "You have Successfully Logged Out");
        return loginView;
    }
    // End Of Logout Method.
}
