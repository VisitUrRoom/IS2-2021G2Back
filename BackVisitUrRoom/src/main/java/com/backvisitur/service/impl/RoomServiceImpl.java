/*package com.backvisitur.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backvisitur.entity.Room;
import com.backvisitur.repository.RoomRepository;
import com.backvisitur.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Room> findAll(Pageable pageable) {
		return roomRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Room> findById(Long id) {
		return roomRepository.findById(id);
	}

	@Override
	@Transactional
	public Room save(Room room) {
		return roomRepository.save(room);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		roomRepository.deleteById(id);
		
	}

	
}*/
