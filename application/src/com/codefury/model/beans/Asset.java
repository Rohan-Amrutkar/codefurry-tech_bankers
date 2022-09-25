package com.codefury.model.beans;

import java.time.LocalDate;

public class Asset {
	private int id;
	private String name;
	private int type;
	private String description;
	private LocalDate dateAdded;
	private int isAvailable;
	private int allocatedTo;
	
	
	
	public Asset() {
		super();
	}

	public Asset(int id, String name, int type, String description, LocalDate dateAdded, int isAvailable,
			int allocatedTo) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.dateAdded = dateAdded;
		this.isAvailable = isAvailable;
		this.allocatedTo = allocatedTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getAllocatedTo() {
		return allocatedTo;
	}

	public void setAllocatedTo(int allocatedTo) {
		this.allocatedTo = allocatedTo;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + ", dateAdded="
				+ dateAdded + ", isAvailable=" + isAvailable + ", allocatedTo=" + allocatedTo + "]";
	}
	
}
