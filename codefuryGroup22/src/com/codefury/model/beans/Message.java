package com.codefury.model.beans;

import java.time.LocalDate;

public class Message {
	private int id;
	private int userId;
	private int assetId;
	private String message;
	private LocalDate dateAdded;
	
	
	public Message() {
		super();
	}


	public Message(int id, int userId, int assetId, String message, LocalDate dateAdded) {
		super();
		this.id = id;
		this.userId = userId;
		this.assetId = assetId;
		this.message = message;
		this.dateAdded = dateAdded;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDate getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}


	public int getAssetId() {
		return assetId;
	}


	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
}
