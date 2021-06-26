package com.backvisitur.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.backvisitur.entity.Room;


public interface RoomService {
	public Iterable <Room> findAll();
	
	public Page<Room> findAll(Pageable pageable);	
	
	public Optional<Room> findById(Long id);
	
	public Room save(Room room);
	
	public void deleteById(Long id);

}
