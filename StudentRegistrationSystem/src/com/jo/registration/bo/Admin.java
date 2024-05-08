package com.jo.registration.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jo.registration.data.Data;
import com.jo.registration.data.MySQLConnection;
import com.jo.registration.errorHandling.ErrorHandling;

public class Admin extends User {
	String adminID;
	public Admin(String fN, String lN, String psw) throws ErrorHandling {
		super(fN,lN,psw);
		//Data.admins.add(this);
		Connection conn = MySQLConnection.conn;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}
	
	}
	public Admin() {
	}

}
