package com.backvisitur.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backvisitur.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{

	void deleteRoomById(Long id);
	Optional<Room> findRoomById(Long id);


}
