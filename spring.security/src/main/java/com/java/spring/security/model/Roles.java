package com.java.spring.security.model;


public class Roles {

	private String userName;
	private String role;
	
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role=role;
    }
}
