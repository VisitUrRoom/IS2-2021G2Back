package com.backvisitur.payload.response;

import java.util.List;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String firstName;
	private String tipopersona;
	private Long userid;
	private String address;
	private String city;
	private String neighborhood;
	private List<String> roles;
	
	
	

	/**
	 * @param token
	 * @param id
	 * @param username
	 * @param email
	 * @param user
	 * @param firstName
	 * @param tipopersona
	 * @param userid
	 * @param address
	 * @param city
	 * @param neighborhood
	 * @param roles
	 */
	public JwtResponse(String accessToken, Long id, String username, String email, String firstName,
			String tipopersona, Long userid, String address, String city, String neighborhood, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.tipopersona = tipopersona;
		this.userid = userid;
		this.address = address;
		this.city = city;
		this.neighborhood = neighborhood;
		this.roles = roles;
	}
	
	
	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getRoles() {
		return roles;
	}
}
