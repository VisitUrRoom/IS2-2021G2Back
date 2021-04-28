package com.backvisitur.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backvisitur.entity.Room;
import com.backvisitur.exeption.UserNotFoundException;
import com.backvisitur.repository.RoomRepository;

@Service
@Transactional
public class RoomService {

	private final RoomRepository roomRepository;

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public Room addRoom(Room room) {
		room.setRoomCode(UUID.randomUUID().toString());
		return roomRepository.save(room);
	}
	
	public List<Room> findallRooms() {
		return roomRepository.findAll();
	}
	
	public Room updateRoom(Room room) {
		return roomRepository.save(room);
	}

	public Room findRoomById(Long id) {
	        return roomRepository.findRoomById(id)
	                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	    }


	public void deleteRoom(Long id){
        roomRepository.deleteRoomById(id);
    }
	
}
