package com.backvisitur.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backvisitur.dtopackage.UserDTO;
import com.backvisitur.entity.User;
import com.backvisitur.payload.response.MessageResponse;
import com.backvisitur.repository.RoleRepository;
import com.backvisitur.repository.UserRepository;
import com.backvisitur.service.impl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USERFREE') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess(Authentication authentication) {
		///Authentication authentication = authenticationFacade.getAuthentication();
		
		Optional<UserDTO> existeUser = userServiceImpl.findByUsername(authentication.getName());
		
		if (existeUser!=null) {
			//return ResponseEntity.badRequest().body(new MessageResponse("Error: el nombre de usuario ya está en uso"));
			return "Contenido" + existeUser.get().getId();
		}
		
		return null;
		
		
		
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
