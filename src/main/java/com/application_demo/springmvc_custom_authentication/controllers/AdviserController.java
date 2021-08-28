package com.application_demo.springmvc_custom_authentication.controllers;


import com.application_demo.springmvc_custom_authentication.functions.Token;
import com.application_demo.springmvc_custom_authentication.models.Login;
import com.application_demo.springmvc_custom_authentication.models.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AdviserController {

    @ModelAttribute("registerUser")
    public User getUserDefaults(){
        return new User();
    }

    @ModelAttribute("userLogin")
    public Login getLoginDefaults(){
        return new Login();
    }


    @ModelAttribute("user_types")
    public List<String> getUserTypes(){
        List<String> userType = new ArrayList<>();
        userType.add("admin");
        userType.add("user");
        return userType;

    }
}
