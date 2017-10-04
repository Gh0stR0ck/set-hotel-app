package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.capgemini.hotel.App.hotel;

@RestController
@RequestMapping("/api/Rooms")
public class roomController {
    public List<Room> roomList = new ArrayList<>();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Room addRoom(@RequestBody Room room) {
        roomList.add(room);
        return room;
    }


    @RequestMapping (value = "/", method = RequestMethod.GET)
    public List<Room> getRooms() {
        return roomList;
    }
}

