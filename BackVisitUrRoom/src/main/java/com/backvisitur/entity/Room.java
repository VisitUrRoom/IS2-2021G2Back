package com.backvisitur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String description;
	private String price;
	private String imageUrl;
	private String number;
	private String location;
	@Column(nullable = false, updatable = false)
	private String roomCode;
	
	public Room() {}
	
	
	
	public Room(Long id, String name, String description, String price, String imageUrl, String number, String location,
			String roomCode) {
		super();
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
		this.number = number;
		this.location = location;
		this.roomCode = roomCode;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}



	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", imageUrl="
				+ imageUrl + ", number=" + number + ", location=" + location + ", roomCode=" + roomCode + "]";
	}
	
	
	
}


