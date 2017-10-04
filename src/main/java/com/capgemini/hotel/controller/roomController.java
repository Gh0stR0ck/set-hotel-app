package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Rooms")
public class roomController {

    @Autowired
    roomRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Room> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Room post(@RequestBody Room room) {
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.PUT)
    public Room put(@RequestBody Room room, @PathVariable long roomNumber) {
        repository.save(room);
        return repository.findOne(room.getRoomNumber());
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Room get(@PathVariable long roomNumber) {
        return repository.findOne(roomNumber);
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable long roomNumber) {
        repository.delete(roomNumber);
        return !repository.exists(roomNumber);
    }
}


