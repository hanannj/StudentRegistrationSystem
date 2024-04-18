package com.jo.registration.bo;

import com.jo.registration.data.Data;

public class Admin extends User {
	public Admin(String fN, String lN, String usn, String psw) {
		super(fN,lN,usn,psw);
		Data.admins.add(this);
}

	public Admin() {
	}

}
