package com.jo.registration.boo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.jo.registration.errorHandling.ErrorHandling;

@Entity
public class Admin extends User {
	@Id
	private String adminID;
	public Admin(String fN, String lN, String psw) throws ErrorHandling {
		super(fN,lN,psw);
		/*try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO users VALUES ('" + fN + "', '" + lN + "', " + psw + "')";
			stmt.execute(query);
		} catch (SQLException e) {
			throw new ErrorHandling("Error occurred during accessing SQL tables", e);
		}*/
	
	}
	public Admin() {
	}

}
