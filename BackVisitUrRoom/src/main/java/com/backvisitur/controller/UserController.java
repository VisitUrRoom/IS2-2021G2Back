package com.backvisitur.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.backvisitur.dtopackage.RoleDTO;
import com.backvisitur.dtopackage.UserDTO;
import com.backvisitur.repository.UserRepository;
//import com.backvisitur.service.impl.RoleServiceImpl;
import com.backvisitur.service.impl.UserServiceImpl;

//@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	@Qualifier("userServiceImpl")
	private UserServiceImpl userServiceImpl;

	//@Autowired
	//@Qualifier("roleServiceImpl")
	//private RoleServiceImpl roleServiceImpl;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	// http://localhost:8081/api/addrole (POST)
	/*@PostMapping("/addrole")
	public RoleDTO addRole(@RequestBody RoleDTO roleDTO) {
		return roleServiceImpl.addRole(roleDTO);
	}*/

	// http://localhost:8081/api/listausuarios (GET)
	@RequestMapping(value = "/listausuarios", method = RequestMethod.GET, produces = "application/json")
	public List<UserDTO> getListUsers() {
		return userServiceImpl.findAllUsers();
	}

	/**
	 * Método para testing del api rest Auth2
	 * 
	 * @return
	 */

	@GetMapping("/check")
	public ResponseEntity<String> checkrest() {
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}

}
