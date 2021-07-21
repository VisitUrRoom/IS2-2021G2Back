package com.backvisitur.entity;

import java.math.BigDecimal;
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
	
<<<<<<< Updated upstream
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 @ManyToOne
	 private User user; // El usuario responsable
	 @ManyToOne
	 private User updateUser; // El usuario que edita
	 
	 @ManyToOne
	 @JoinColumn(updatable = false)
	 private User ownerUser; // El usuario que creo
	 @JoinColumn(updatable = false)
	 private LocalDateTime registerTime;
	 @JoinColumn(updatable = false)
	 private LocalDateTime updateTime;  
	
=======
	@ManyToOne
	@JoinColumn(updatable = false)
	private User ownerUser; // El usuario que creo
	private LocalDateTime registerTime;
	@JoinColumn(updatable = false)
	private LocalDateTime updateTime;  

>>>>>>> Stashed changes
	private String title;
	private String desctription;
	private String price;
	private String image;

	private Integer area;
	@Column(nullable = false, updatable = false)
	private String direccion;
	private Integer superficie;
	private String tipo;
<<<<<<< Updated upstream
	@Column(nullable = false, updatable = false)
	private String lat;
	@Column(nullable = false, updatable = false)
	private String lng;
	
	
	public Room(){
		
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getArea() {
		return area;
	}


	public void setArea(Integer area) {
=======
	@Column(name = "lat", columnDefinition="DECIMAL(16,12)", nullable = false, updatable = false)
	private BigDecimal lat;
	@Column(name = "lng", columnDefinition="DECIMAL(16,12)", nullable = false, updatable = false)
	private BigDecimal lng;
	/**
	 * @param id
	 * @param ownerUser
	 * @param registerTime
	 * @param updateTime
	 * @param title
	 * @param desctription
	 * @param price
	 * @param image
	 * @param area
	 * @param direccion
	 * @param superficie
	 * @param tipo
	 * @param lat
	 * @param lng
	 */
	public Room(Long id, User ownerUser, LocalDateTime registerTime, LocalDateTime updateTime, String title,
			String desctription, String price, String image, Integer area, String direccion, Integer superficie,
			String tipo, BigDecimal lat, BigDecimal lng) {
		super();
		this.id = id;
		this.ownerUser = ownerUser;
		this.registerTime = registerTime;
		this.updateTime = updateTime;
		this.title = title;
		this.desctription = desctription;
		this.price = price;
		this.image = image;
>>>>>>> Stashed changes
		this.area = area;
		this.direccion = direccion;
		this.superficie = superficie;
		this.tipo = tipo;
		this.lat = lat;
		this.lng = lng;
	}
	
	
	public Room() {
		super();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	
	

}
