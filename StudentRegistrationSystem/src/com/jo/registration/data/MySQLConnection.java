package com.jo.registration.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jo.registration.errorHandling.ErrorHandling;


public class MySQLConnection {
	public void connect() throws ErrorHandling {
        Connection conn = null;
        
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://localhost/studentregistrationsystem?" +
                    "user=root&password=12345678");

            System.out.println("Connected!");

        } catch (SQLException ex) {
        	throw new ErrorHandling("Error occurred while connecting to MySQL", ex);
        	
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            	throw new ErrorHandling("Error occurred while disconnecting MySQL", ex);
            }
        }
    }
}
