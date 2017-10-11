package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.*;
import com.capgemini.hotel.repository.GuestRepository;
import com.capgemini.hotel.repository.ReservationRepository;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/init")
public class InitController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialize() {
        Guest guest = new Guest();

        guest.setName("Voornaam");
        guest.setSurname("Achternaam");
        guest.setAddress("Address 123");
        guest.setCity("City");
        guest.setEmail("email@email.com");
        guest.setPhone("0612345678");
        guest.setCountry("Country");
        guest.setZipcode("1234AB");

        guestRepository.save(guest);

        Room room = new Room();

        room.setRoomType(RoomType.BUDGET);
        room.setRoomName("Room 1");
        room.setRoomSize(RoomSize.FIVESIXPERSONS);
        room.setRoomStatus(RoomStatus.OPERATIONAL);

        roomRepository.save(room);

        return "initialized";
    }
}

