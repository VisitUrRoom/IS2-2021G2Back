package com.backvisitur.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backvisitur.entity.User;
import com.backvisitur.repository.UserRepository;
import com.backvisitur.service.impl.UserServiceImpl;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	//@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 com.backvisitur.entity.User user = userRepository.findByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("No se pudo encontrar el usuario");
	        }
	         
	        return new UserDetailsImpl(user);
	    }
	
	/*public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}*/

}