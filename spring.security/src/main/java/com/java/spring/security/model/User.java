package com.java.spring.security.model;

public class User {
    private String userName;
    private String password;
    private Boolean enabled;
    private String role;
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", role=" + role
				+ "]";
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
       this.password=password;
    }
    
    public Boolean getEnabled() {
    	return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
    	this.enabled=enabled;
    }

    
}