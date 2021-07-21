package com.backvisitur.converter;

import java.util.stream.Collectors;

import com.backvisitur.dtopackage.UserDTO;
import com.backvisitur.entity.User;

public class UserConverter extends AbstractConverter<User, UserDTO>{

	@Override
	public User fromDto(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		//user.setPassword(dto.getPassword());
		
		// Prevent NullPointerException
		/*if(dto.getRoles()!=null) {
			user.setRoles(dto.getRoles().stream().map(rol -> Role.valueOf(rol)).collect(Collectors.toList()));
		}*/
		return user;
	}

	@Override
	public UserDTO fromEntity(User entity) {
		UserDTO user = new UserDTO();
		user.setId(entity.getId());
		user.setUsername(entity.getUsername());
		//user.setPassword(entity.getPassword());
		
		// Prevent NullPointerException
		/*if(entity.getRoles()!=null) {
			user.setRoles(entity.getRoles().stream().map(rol -> rol.name()).collect(Collectors.toList()));
		}*/
		return user;
	}
}