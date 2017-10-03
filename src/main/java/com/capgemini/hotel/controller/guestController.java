package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.GuestManager;
import com.capgemini.hotel.model.Hotel;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.capgemini.hotel.App.hotel;

@RestController
public class guestController {


    @RequestMapping("/api/guest")
    @ResponseBody
    public List<Guest> guestList() {

        Guest guest1 = new Guest("Surname", "Name", null, null, null, null, null, null);
        Guest guest2 = new Guest("Surname2", "Name", null, null, null, null, null, null);
        Guest guest3 = new Guest("Surname3", "Name", "ad", "zc", "ci", "ctry", "0654", "email");
        hotel.guestManager.addGuest(guest1);
        hotel.guestManager.addGuest(guest2);
        hotel.guestManager.addGuest(guest3);

        return hotel.guestManager.getGuestList();


    }
}