package com.backvisitur.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backvisitur.dtopackage.UserDTO;
import com.backvisitur.entity.Role;
import com.backvisitur.entity.User;
import com.backvisitur.repository.RoleRepository;
import com.backvisitur.repository.UserRepository;
import com.backvisitur.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	@Autowired
	@Qualifier("bCryptPasswordEncoder")
	BCryptPasswordEncoder bCryptPasEncoder;
	*/
	
	
	@Autowired /** Se Inyecta el repositorio ROLE */
	@Qualifier("roleRepository")
	private RoleRepository roleRepository;
	
	@Autowired // Se Inyecta el repositorio USER
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public Optional<UserDTO> findByUsername(String username) {
		User user = new User();
		UserDTO userDTO = new UserDTO();
		user = userRepository.findByUsername(username);
		if (user == null) {
            return Optional.empty();
        } else {
        	userDTO.setId(user.getId());
        	userDTO.setEmail(user.getEmail());
        	userDTO.setFirstName(user.getFirstName());
        	userDTO.setLastName(user.getLastName());
        	userDTO.setUsername(user.getUsername());
        	userDTO.setRoles(user.getRoles());
            return Optional.of(userDTO);
        }
		
	}
	
	@Override
	public boolean addUser(UserDTO userDTO, Integer id) {
		User user = new User();
		Role role = roleRepository.findRoleById(id);
		
		if(null != role) {
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setUsername(userDTO.getUsername());
		
		user.setRoles(Collections.singletonList( role ) );
		userRepository.save( user );
		return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		/** Lista de usuarios */
		List<User> users = userRepository.findAll();
		/** lista que recibe la entidad usurio convertido de user a userDTO */
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		UserDTO userDTO = new UserDTO(); 
		for (User user : users) {
			
			userDTO.setId(user.getId());
        	userDTO.setEmail(user.getEmail());
        	userDTO.setFirstName(user.getFirstName());
        	userDTO.setLastName(user.getLastName());
        	userDTO.setUsername(user.getUsername());
        	userDTO.setRoles(user.getRoles());
        	listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	
	
}
