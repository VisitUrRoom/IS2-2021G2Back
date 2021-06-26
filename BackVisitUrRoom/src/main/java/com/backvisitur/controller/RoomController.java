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
@RequestMapping("/api/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	//Create new Room
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> create (@RequestBody Room room){
		room.setRegisterTime(LocalDateTime.now());
		room.setUpdateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.save(room));
		
	}
	
	//Read a Room
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long roomId){
		Optional <Room> oRoom = roomService.findById(roomId);
		
		if(!oRoom.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oRoom);
	}
	
	//Update a Room
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> update (@RequestBody Room roomDetails, @PathVariable(value = "id") Long roomId){
		Optional <Room> room = roomService.findById(roomId);
		
		if(!room.isPresent()) {
			return ResponseEntity.notFound().build(); 
		}
	
		room.get().setTitle(roomDetails.getTitle());
		room.get().setDesctription(roomDetails.getDesctription());
		room.get().setPrice(roomDetails.getPrice());
		room.get().setImage(roomDetails.getImage());
		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.save(room.get()));
	}
	
	//Delete a Room
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> delete ( @PathVariable(value = "id") Long roomId)	{
		if(!roomService.findById(roomId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		roomService.deleteById(roomId);
		return ResponseEntity.ok().build();
	}
	
	//Read all rooms
	@GetMapping("/lista")
	public List<Room> readAll(){
		List <Room> employees = StreamSupport
				.stream(roomService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return employees;
		
	}
}
	


   



