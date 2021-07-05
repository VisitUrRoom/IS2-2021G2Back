package com.backvisitur.service;

import java.util.List;
import java.util.Optional;

import com.backvisitur.dtopackage.UserDTO;

public interface UserService {
	public boolean addUser(UserDTO userDTO, Integer id);
	public Optional<UserDTO> findByUsername(String username);
	public abstract List<UserDTO> findAllUsers();
}
