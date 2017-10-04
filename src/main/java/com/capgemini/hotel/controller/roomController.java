package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.capgemini.hotel.App.hotel;

//public class roomController {
//    @RequestMapping("/api/guest")
//    @ResponseBody
//    public List<Room> roomList() {
//
//        Room room1 = new Room("Surname", "Name", null, null);
//        Guest guest2 = new Guest("Surname2", "Name", null, null, null, null, null, null);
//        Guest guest3 = new Guest("Surname3", "Name", "ad", "zc", "ci", "ctry", "0654", "email");
//        hotel.guestManager.addGuest(guest1);
//        hotel.guestManager.addGuest(guest2);
//        hotel.guestManager.addGuest(guest3);
//
//        return hotel.guestManager.getRoomList();
//
//
//    }
//}
//}
