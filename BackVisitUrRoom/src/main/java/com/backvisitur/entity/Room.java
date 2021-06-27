package com.backvisitur.entity;
import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "rooms")
public class Room {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User user; // El usuario responsable
	@ManyToOne
	private User updateUser; // El usuario que edita
	@ManyToOne
	private User ownerUser; // El usuario que creo 
	private LocalDateTime registerTime;  
	private LocalDateTime updateTime;  

	private String name;
	private String description;
	private Integer price;
	private String imageUrl;
	private String number;
	private String location;
	
	public Room(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	
	public User getOwnerUser() {
		return ownerUser;
	}
	
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
	
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
	
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
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
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
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

}
