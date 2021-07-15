package com.backvisitur.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backvisitur.entity.Room;
import com.backvisitur.service.RoomService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	//Create new Room

	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_USERFREE') or hasRole('ROLE_USERPRIME') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> create (@RequestBody Room room){
		room.setRegisterTime(LocalDateTime.now());
		room.setUpdateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.save(room));
		
	}
	
	//Read a Room
	@GetMapping("/find/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id){
		Room  room = roomService.findRoomById(id);
			return new ResponseEntity<>(room, HttpStatus.OK);
	}
		
	
	//Update a Room
	@PutMapping("/update")
	@PreAuthorize("hasRole('ROLE_USERFREE') or hasRole('ROLE_USERPRIME') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room){
		Room updateRoom = roomService.updateRoom(room);
		return new ResponseEntity<>(updateRoom, HttpStatus.OK);
	}
	
	//Delete a Room
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_USERFREE') or hasRole('ROLE_USERPRIME') or hasRole('ROLE_ADMIN')")
	 public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	//Read all rooms
	@GetMapping("/all")
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> rooms = roomService.findallRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);

	}
}
