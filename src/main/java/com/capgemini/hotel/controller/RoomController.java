package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.model.RoomSize;
import com.capgemini.hotel.model.RoomStatus;
import com.capgemini.hotel.model.RoomType;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Rooms")
public class RoomController {


    @Autowired
    RoomRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Room> getAll() {
        Room room = new Room(1L, RoomType.BUDGET, RoomSize.FIVESIXPERSON, RoomStatus.OPERATIONAL);
        repository.save(room);
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Room post(@RequestBody Room room) {
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Room get(@PathVariable long roomNumber) {
        return repository.findOne(roomNumber);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Room put(@RequestBody Room room) {
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Room delete(@RequestBody Room room) {
        repository.delete(room);
        return repository.findOne(room.getRoomNumber());
    }

}


