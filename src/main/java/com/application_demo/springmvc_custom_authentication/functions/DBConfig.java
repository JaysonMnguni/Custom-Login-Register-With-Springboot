package com.application_demo.springmvc_custom_authentication.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

    // Database Credentials:
    private static final String DB_USERNAME = "Jayson";
    private static final String DB_PASSWORD = "jayson123";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/springboot_custom_login";

    // Database Connection Method:
    public static Connection getConnection(){
        Connection connect = null;

        // Connection Setup Try Block:
        try {
            return connect = DriverManager.getConnection(CONNECTION_STRING,DB_USERNAME, DB_PASSWORD);

        }catch (SQLException e){
            e.printStackTrace();
        }
        // End of Connection Setup Try Block.

        return connect;

    }
    // End Of Database Connection Method.


}
