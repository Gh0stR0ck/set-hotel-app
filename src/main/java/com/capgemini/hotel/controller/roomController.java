package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.capgemini.hotel.App.hotel;

public class roomController {
    @RequestMapping("/api/Rooms")
    @ResponseBody
    public List<Room> roomList() {

        Room room1 = new Room(null, null, null, null);
        Room room2 = new Room(null, null, null, null);
        Room room3 = new Room(null, null, null, null);
        hotel.roomManager.addRoom(room1);
        hotel.roomManager.addRoom(room2);
        hotel.roomManager.addRoom(room3);

        return hotel.roomManager.getRoomList();


    }
}
}
