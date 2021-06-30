package com.backvisitur.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backvisitur.constant.ERole;
import com.backvisitur.entity.Role;
import com.backvisitur.entity.User;
import com.backvisitur.payload.request.LoginRequest;
import com.backvisitur.payload.request.SignupRequest;
import com.backvisitur.payload.response.JwtResponse;
import com.backvisitur.payload.response.MessageResponse;
import com.backvisitur.repository.RoleRepository;
import com.backvisitur.repository.UserRepository;
import com.backvisitur.security.jwt.JwtUtils;
import com.backvisitur.security.services.UserDetailsImpl;
//import com.backvisitur.service.impl.RoleServiceImpl;
import com.backvisitur.service.impl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;

	/*@Autowired
	@Qualifier("roleServiceImpl")
	private RoleServiceImpl roleServiceImpl;*/

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 userDetails.getFirstName(),
												 userDetails.getTipopersona(),
												 userDetails.getUserid(),
												 userDetails.getAddress(),
												 userDetails.getCity(),
												 userDetails.getNeighborhood(),
												 roles));
	}
	
	

	@PostMapping("/signup")
	
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: el nombre de usuario ya está en uso"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: el correo electrónico ya está en uso!"));
		}

		// Crear cuenta de usuario
		User user = new User(signUpRequest.getUsername(), 
			 				signUpRequest.getEmail(),
			 				encoder.encode(signUpRequest.getPassword()),
			 				signUpRequest.getFirstName(), 
			 				signUpRequest.getTipopersona(), 
			 				signUpRequest.getUserid(),  
			 				signUpRequest.getAddress(), 
			 				signUpRequest.getCity(), 
			 				signUpRequest.getNeighborhood());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USERFREE)
					.orElseThrow(() -> new RuntimeException("Error: El Role no se encuentra."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: no se encuentra el rol."));
					roles.add(adminRole);

					break;
				case "prime":
					Role modRole = roleRepository.findByName(ERole.ROLE_USERPRIME)
							.orElseThrow(() -> new RuntimeException("Error: no se encuentra el rol"));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USERFREE)
							.orElseThrow(() -> new RuntimeException("Error: no se encuentra el rol"));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("¡Usuario registrado exitosamente!"));
	}
}