package com.backvisitur.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

@RestController
@RequestMapping("/room")
public class RoomController {
	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> rooms = roomService.findallRooms();
		return new ResponseEntity<>(rooms, HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id){
	Room  room = roomService.findRoomById(id);
		return new ResponseEntity<>(room, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		Room newRoom = roomService.addRoom(room);
		return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room){
		Room updateRoom = roomService.updateRoom(room);
		return new ResponseEntity<>(updateRoom, HttpStatus.OK);
	}
	
	  /*@DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deteleRoom(@PathVariable("id") Long id) {
	        roomService.deteleRoom(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }*/
	
	  
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {
	        roomService.deleteRoom(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	
}
