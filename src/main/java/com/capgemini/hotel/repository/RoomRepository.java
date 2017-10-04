package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long>{
}