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
	
	private String title;
	private String desctription;
	private Integer price;
	private String image;
	
	private Integer area;
	private String direccion;
	private String superficie;
	private Integer lat;
	private String lng;
	
	
	public Room(){
		
	}
	

	public Integer getArea() {
		return area;
	}


	public void setArea(Integer area) {
		this.area = area;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getSuperficie() {
		return superficie;
	}


	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}


	public Integer getLat() {
		return lat;
	}


	public void setLat(Integer lat) {
		this.lat = lat;
	}


	public String getLng() {
		return lng;
	}


	public void setLng(String lng) {
		this.lng = lng;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesctription() {
		return desctription;
	}

	public void setDesctription(String desctription) {
		this.desctription = desctription;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
