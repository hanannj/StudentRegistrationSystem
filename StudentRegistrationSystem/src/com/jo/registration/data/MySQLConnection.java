package com.jo.registration.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jo.registration.errorHandling.ErrorHandling;


public class MySQLConnection {
	public static Connection conn = null;
	public void connect() throws ErrorHandling {
        
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/studentregistrationsystem?" +
                    "user=root&password=12345678"+"&autoReconnect=true");

            System.out.println("Connected!");

        } catch (SQLException ex) {
        	throw new ErrorHandling("Error occurred while connecting to MySQL", ex);
        	
        } 
    }
	public void closeConnection() throws ErrorHandling {
		try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
        	throw new ErrorHandling("Error occurred while disconnecting MySQL", ex);
        }
	}
}
