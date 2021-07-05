package com.backvisitur.dtopackage;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.backvisitur.entity.Role;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062279178869816704L;

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Set<String> role;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id) {
		super();
		this.id = id;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Set<String> getRole() {
	      return this.role;
	    }
	    
    public void setRole(Set<String> role) {
      this.role = role;
    }

}
