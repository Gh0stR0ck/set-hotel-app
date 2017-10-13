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
        guest.setName("Victor");
        guest.setSurname("Tenbergen");
        guest.setAddress("Zijkstraat 123");
        guest.setCity("Enschede");
        guest.setEmail("victor@tenbergen.com");
        guest.setPhone("0699887766");
        guest.setCountry("Nederland");
        guest.setZipcode("1244AB");
        guestRepository.save(guest);

        guest = new Guest();
        guest.setName("Ramon");
        guest.setSurname("Vaan, de");
        guest.setAddress("Lampengat 123");
        guest.setCity("Eindhoven");
        guest.setEmail("ramon@vaan.com");
        guest.setPhone("0612345678");
        guest.setCountry("Nederland");
        guest.setZipcode("3465AB");
        guestRepository.save(guest);

        guest = new Guest();
        guest.setName("Kelvin");
        guest.setSurname("Hubertts");
        guest.setAddress("Weide 2");
        guest.setCity("Arnhem");
        guest.setEmail("kelvin@huberts.com");
        guest.setPhone("0612345678");
        guest.setCountry("Nederland");
        guest.setZipcode("8976AB");
        guestRepository.save(guest);

        guest = new Guest();
        guest.setName("Wesley");
        guest.setSurname("Jansen");
        guest.setAddress("Cuijkstraat 67");
        guest.setCity("Cuijk");
        guest.setEmail("wesley@jansen.com");
        guest.setPhone("0688553322");
        guest.setCountry("Nederland");
        guest.setZipcode("8976AB");
        guestRepository.save(guest);

        guest = new Guest();
        guest.setName("Duncan");
        guest.setSurname("Burger");
        guest.setAddress("Plein 4");
        guest.setCity("Den Haag");
        guest.setEmail("duncan@burger.nl");
        guest.setPhone("0654617522");
        guest.setCountry("Nederland");
        guest.setZipcode("2593SJ");
        guestRepository.save(guest);

        guest = new Guest();
        guest.setName("Akin");
        guest.setSurname("Ekim");
        guest.setAddress("Leasestraat 123");
        guest.setCity("Arnhem");
        guest.setEmail("akin@ekim.nl");
        guest.setPhone("068877223311");
        guest.setCountry("Nederland");
        guest.setZipcode("1265KL");
        guestRepository.save(guest);


        Room room = new Room();
        room.setRoomType(RoomType.BUDGET);
        room.setRoomName("Room 1");
        room.setRoomSize(RoomSize.FIVESIXPERSONS);
        room.setRoomStatus(RoomStatus.OPERATIONAL);
        roomRepository.save(room);

        room = new Room();
        room.setRoomType(RoomType.LUXURY);
        room.setRoomName("Suite 1");
        room.setRoomSize(RoomSize.TWOPERSONS);
        room.setRoomStatus(RoomStatus.OPERATIONAL);
        roomRepository.save(room);

        room = new Room();
        room.setRoomType(RoomType.NORMAL);
        room.setRoomName("Room 2");
        room.setRoomSize(RoomSize.THREEFOURPERSONS);
        room.setRoomStatus(RoomStatus.BLOCKED);
        roomRepository.save(room);

        return "initialized";
    }
}

