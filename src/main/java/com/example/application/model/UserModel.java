package com.example.application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserModel {

	@Id
    private String email;

    private String password;

    private String username;

    private String mobileNumber;
    
    private String address;

    private Boolean active;

    private String role;
    
    @OneToMany(mappedBy="createdBy", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<ResourceModel> resourceModel;
    
    @OneToMany(mappedBy="primaryUser")
    private List<ChatModel> primaryChatModel;
    
    @OneToMany(mappedBy="secondaryUser")
    private List<ChatModel> secondaryChatModel;
    
    public UserModel() {
    	
    }
    
	public UserModel(String email, String password, String username, String mobileNumber, String address,
			Boolean active, String role) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.active = active;
		this.role = role;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
   

}
