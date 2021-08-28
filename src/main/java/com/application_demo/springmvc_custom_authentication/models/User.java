package com.application_demo.springmvc_custom_authentication.models;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @Id
    private int user_id;
    @NotBlank(message = "The first name field is required")
    @Size(min = 3, message = "The first name field has to be more than 3 characters")
    private String first_name;
    @NotBlank(message = "The last name field is required")
    @Size(min = 3, message = "The last name field has to be more than 3 characters")
    private String last_name;
    @NotBlank(message = "The Email field is required")
    @Email
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})",message="Please enter a valid email address")
    private String email;
    @NotBlank(message = "The Password field is required")
    private String password;
    @NotBlank(message = "The Confirm Password field is required")
    private String confirm_password;
    @NotBlank(message = "The User Type field is required")
    private String user_type;
    private String verification_token;
    private int active;
    private int verified;
    private Date verified_on;
    private Date created_at;
    private Date updated_at;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

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
    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getVerification_token() {
        return verification_token;
    }

    public void setVerification_token(String verification_token) {
        this.verification_token = verification_token;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public Date getVerified_on() {
        return verified_on;
    }

    public void setVerified_on(Date verified_on) {
        this.verified_on = verified_on;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
