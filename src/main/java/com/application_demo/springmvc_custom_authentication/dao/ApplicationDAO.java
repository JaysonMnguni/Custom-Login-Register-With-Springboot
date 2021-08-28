package com.application_demo.springmvc_custom_authentication.dao;

import com.application_demo.springmvc_custom_authentication.functions.DBConfig;
import com.application_demo.springmvc_custom_authentication.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDAO {

    // Register User Method:
    public static boolean registerUser(String first_name, String last_name, String email,  String password,String user_type, String verification_token ) throws SQLException {
        Connection connect = null;
        String registerUserQuery =  "INSERT INTO users (first_name, last_name, email, password, user_type,verification_token)" +
                "VALUES(?, ?, ?, ?, ?, ?)";

        // Register User Try Block:
        try {
            // Initialize Connection:
            connect = DBConfig.getConnection();

            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(registerUserQuery);

            // Set Statement Parameters:
            statement.setString(1, first_name);
            statement.setString(2, last_name);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, user_type);
            statement.setString(6, verification_token);

            // Execute Query:
            int affectedRows = statement.executeUpdate();

            // Check for Affected Rows:
            if(affectedRows == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to register User!");
        }finally {
            if (connect != null){
                connect.close();
                System.out.println("Closing DB Connection!");
            }
        }
        // End Of Register User Try Block:
        return false;
    }
    // End Of Register User Method.

    // Validate Email:
    public static boolean isRegisteredEmail(String email) throws SQLException{
        Connection connect = null;
        ResultSet set = null;
        String isRegisteredEmailSQL = "SELECT email FROM users where email = ?";

        // Check Email Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare SQL Statement:
            PreparedStatement statement = connect.prepareStatement(isRegisteredEmailSQL);
            // Set Attributes / Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            // check for results:
            while (set.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(set != null){
                set.close();
            }
            if (connect != null){
                connect.close();
                System.out.println("Closing DB Connection!");
            }
        }
        // End Of Check Email Try Block.
        return false;
    }
    // End Of Validate Email.


    // Get Stored User Hashed Password:
    public static String getStoredHashedUserPassword(String email) throws SQLException{
        Connection connect = null;
        ResultSet set = null;
        String hashed_password = null;
        String getHashedPasswordSQL = "SELECT password FROM users WHERE email = ?";

        // Get Hashed Password in Database Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare SQL Statement:
            PreparedStatement statement = connect.prepareStatement(getHashedPasswordSQL);
            // Set Attributes / Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            while (set.next()){
                hashed_password = set.getString("password");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(set != null){
                set.close();
            }
            if (connect != null){
                connect.close();
                System.out.println("Closing DB Connection!");
            }
        }
        // End Of Get Hashed Password in Database Try Block.

        return  hashed_password;
    }
    // End Of Get Stored User Hashed Password.

    // Get User Type:
    public static String getUserType(String email){
        Connection connect = null;
        ResultSet set = null;
        String userType = null;
        String getUserTypeSQL = "SELECT user_type FROM users WHERE email= ?";

        // Get User Type Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare SQL Statement:
            PreparedStatement statement = connect.prepareStatement(getUserTypeSQL);
            // Set Attributes / Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            // Check For Results:
            while (set.next()){
                userType = set.getString("user_type");
            }
            // End Of Check For Results:.

        }catch (Exception e){
            e.printStackTrace();
        }

        // End Of Get User Type Try Block.
        return userType;
    }
    // End Of Get User Type.


    // Get User Information / Details:
    public static User getUser(String email){
        Connection connect = null;
        ResultSet set = null;
        String getUserSQL = "SELECT * FROM users WHERE email =?";
        User user = null;

        // Get User Details Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare SQL Statement:
            PreparedStatement statement = connect.prepareStatement(getUserSQL);
            // Set Attributes / Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            // Check For Results:
            while (set.next()){
                user = new User();
                // Set User Details / Information
                user.setFirst_name(set.getString("first_name"));
                user.setLast_name(set.getString("last_name"));
                user.setEmail(set.getString("email"));
                user.setUser_type(set.getString("user_type"));
                user.setCreated_at(set.getDate("created_at"));
            }
            // End Of Check For Results:.
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    // End Of Get User Information / Details.

    // Check If Account Is Verified:
    public static boolean isAccountVerified(String email){
        Connection connect = null;
        ResultSet set = null;
        String isAccountVerifiedSQL = "SELECT verified FROM users WHERE email = ?";

        // Check If Account is Verified Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(isAccountVerifiedSQL);
            // Set Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            // Check For Result Set:
            while (set.next()){
                // Check Value:
                 if(set.getInt("verified") == 1) {
                     return true;
                 }
                // End Of Check Value.
            }
            // End Of Check For Result Set.

        }catch(SQLException e){
            e.printStackTrace();
        }
        // End Of Check If Account is Verified Try Block:

        return false;
    }
    // End Of Check If Account Is Verified.


    // Check If Account Is Active:
    public static boolean isAccountActive(String email){
        Connection connect = null;
        ResultSet set = null;
        String isAccountActiveSQL = "SELECT active FROM users WHERE email = ?";

        // Check If Account is Active Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(isAccountActiveSQL);
            // Set Parameters:
            statement.setString(1, email);
            // Execute Statement:
            set = statement.executeQuery();
            // Check For Result Set:
            while (set.next()){
                // Check Value:
                if(set.getInt("active") == 1) {
                    return true;
                }
                // End Of Check Value.
            }
            // End Of Check For Result Set.

        }catch(SQLException e){
            e.printStackTrace();
        }
        // End Of Check If Account is Active Try Block:

        return false;
    }
    // End Of Check If Account Is Active.

    // Update Passwords An Verify Account:
    public static boolean verifyAccount(String password, String email, String token){
        Connection connect = null;
        String verifyAccountSQL = "UPDATE users SET  password = ?, verification_token = null, active = 1, verified = 1, verified_on = NOW() "+
                    "WHERE email =? AND verification_token =?";

        // Verify Account Try Block:
        try{
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(verifyAccountSQL);
            // Set Attributes:
            statement.setString(1, password);
            statement.setString(2, email);
            statement.setString(3, token);

            // Execute Statement:
            int rowsAffected = statement.executeUpdate();

            // Check For Rows Affected:
            if(rowsAffected == 1){
                return true;
            }
            // Check For Rows Affected.

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to Verify / Update Account");
        }
        // End Of Verify Account Try Block:

        return false;

    }
    // End Of Update Passwords An Verify Account.

    // Verify Token:
    public static boolean verifyToken(String email, String token){
        Connection connect = null;
        ResultSet set = null;
        String verifyTokenSQL = "SELECT verification_token FROM users WHERE email = ? and verification_token = ?";

        // Verify Token Try Block:
        try{
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(verifyTokenSQL);
            // Set Attributes:
            statement.setString(1, email);
            statement.setString(2, token);

            // Execute Statement:
            set = statement.executeQuery();

            // Check For Rows Affected:
            while (set.next()){
                return true;
            }
            // Check For Rows Affected.

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to Verify / Update Account");
        }
        // End Of Verify Token Try Block:

        return false;
    }
    // End Of Verify Token.


    // Set Verification Token:
    public static boolean setVerificationToken(String email, String token){
        Connection connect = null;
        String setTokenSQL = "UPDATE users SET  verification_token = ?  WHERE email = ?";

        // Check If Account is Active Try Block:
        try {
            // Set Connection:
            connect = DBConfig.getConnection();
            // Prepare Statement:
            PreparedStatement statement = connect.prepareStatement(setTokenSQL);
            // Set Parameters:
            statement.setString(1, token);
            statement.setString(2, email);
            // Execute Statement:
            int rowsAffected = statement.executeUpdate();

            // Check For Rows Affected:
            if(rowsAffected == 1){
                return true;
            }
            // Check For Rows Affected.

        }catch(SQLException e){
            e.printStackTrace();
        }
        // End Of Check If Account is Active Try Block:

        return false;

    }
    // End Of Set Verification Token.
}
