package com.backvisitur.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backvisitur.entity.Role;
import com.backvisitur.entity.User;



public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private User user;
	private String firstName;
	private String tipopersona;
	private Long userid;
	private String address;
	private String city;
	private String neighborhood;
	private String phone;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return authorities;
	}
	
	
	
	public Long getId() {
		return user.getId();
	}

	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public String getFirstName() {
		return user.getFirstName();
	}

	public String getTipopersona() {
		return user.getTipopersona();
	}

	public Long getUserid() {
		return user.getUserid();
	}

	public String getAddress() {
		return user.getAddress();
	}

	public String getCity() {
		return user.getCity();
	}

	public String getNeighborhood() {
		return user.getNeighborhood();
	}
	
	public String getPhone() {
		return user.getPhone();
	}
	


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
