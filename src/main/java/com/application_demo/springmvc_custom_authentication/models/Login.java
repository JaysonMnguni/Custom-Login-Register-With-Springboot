package com.application_demo.springmvc_custom_authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Login {

    @NotBlank(message= "The Email field is required!")
    @Email
    private String email;
    @NotBlank(message= "The Password field is required!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
