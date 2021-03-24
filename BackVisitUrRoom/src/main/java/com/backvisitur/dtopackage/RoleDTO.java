package com.backvisitur.dtopackage;

import java.io.Serializable;
public class RoleDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String name;

	/**
	 * Getters and Setters
	 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setRoleName(String name) {
		this.name = name;
	}


}
