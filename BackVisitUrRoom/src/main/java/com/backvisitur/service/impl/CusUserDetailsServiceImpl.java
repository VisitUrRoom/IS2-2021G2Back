package com.backvisitur.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backvisitur.entity.Role;
import com.backvisitur.repository.UserRepository;
import com.backvisitur.security.CusUserDetails;

@Service
public class CusUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;


	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 com.backvisitur.entity.User user = userRepository.findByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new CusUserDetails(user);
	    }
	
	
	
	
	/**
	 * Otra forma de implementar User Deails Services
	 *
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.backvisitur.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getRoles());
		return builderUser(user, authorities );
	}

	private User builderUser(com.backvisitur.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(List<Role> roles) {
		List<GrantedAuthority> gAuth = new ArrayList<>();
		for (Role role : roles) {
			gAuth.add(new SimpleGrantedAuthority(role.getName()));
		}

		return gAuth;
	}
	*/
}
