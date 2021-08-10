package com.example.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ChatModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;
	
	@ManyToOne
	private UserModel primaryUser;
	
	@ManyToOne
	private UserModel secondaryUser;

	@ElementCollection
	private List<String> chatHistory = new ArrayList<>();
	
	private Boolean status;
	
    private Date lastSeen;

    
	public ChatModel(Long chatId, UserModel primaryUser, UserModel secondaryUser, List<String> chatHistory,
			Boolean status, Date lastSeen) {
		super();
		this.chatId = chatId;
		this.primaryUser = primaryUser;
		this.secondaryUser = secondaryUser;
		this.chatHistory = chatHistory;
		this.status = status;
		this.lastSeen = lastSeen;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	public UserModel getPrimaryUser() {
		return primaryUser;
	}

	public void setPrimaryUser(UserModel primaryUser) {
		this.primaryUser = primaryUser;
	}

	public UserModel getSecondaryUser() {
		return secondaryUser;
	}

	public void setSecondaryUser(UserModel secondaryUser) {
		this.secondaryUser = secondaryUser;
	}

	public List<String> getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(List<String> chatHistory) {
		this.chatHistory = chatHistory;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}
    
    

    
}
