package com.backvisitur.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column
	private String firstName;
	@Column
	private String tipopersona;
	@Column
	private Long userid;
	@Column
	private String email;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String neighborhood;
	@Column
	private String phone;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	//private List<Role> roles;
	private Set<Role> roles = new HashSet<>();

	public User() {
		
	}
	
	

	/**
	 * @param id
	 * @param firstName
	 * @param tipopersona
	 * @param userid
	 * @param email
	 * @param username
	 * @param password
	 * @param address
	 * @param city
	 * @param neighborhood
	 * @param roles
	 */
	public User(String username, String email, String password, String firstName,
			String tipopersona, Long userid, String address, String city, String neighborhood, String phone) {
		super();
		this.firstName = firstName;
		this.tipopersona = tipopersona;
		this.userid = userid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.city = city;
		this.neighborhood = neighborhood;
		this.phone = phone;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	

}