package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.model.ReservationDTO;
import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.GuestRepository;
import com.capgemini.hotel.repository.ReservationRepository;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ArrayList<ReservationDTO> getAll() {

        // get all reservations from repository
        Iterable<Reservation> reservationList = reservationRepository.findAll();
        ArrayList<ReservationDTO> reservationDTOList = new ArrayList<>();

        //  Iterate over the reservations
        for (Reservation reservation : reservationList) {

            ReservationDTO reservationDTO = new ReservationDTO();
            // Map 1:1 fields
            if (reservation.getReservationNumber() >= 0)
                reservationDTO.setReservationNumber(reservation.getReservationNumber());
            reservationDTO.setStartDate(reservation.getStartDate());
            reservationDTO.setEndDate(reservation.getEndDate());
            if (reservation.getGuest() != null) {
                reservationDTO.setGuestId(reservation.getGuest().getGuestNumber());
                reservationDTO.setGuestName(
                        reservation.getGuest().getName() + " " +
                                reservation.getGuest().getSurname()
                );
            }
            if (reservation.getRoom() != null) {
                reservationDTO.setRoomId(reservation.getRoom().getRoomNumber());
                reservationDTO.setRoomName(
                        reservation.getRoom().getRoomName()
                );
            }


            DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
            reservationDTO.setStartDateFormatted(
                    f.format(reservation.getStartDate())
            );
            reservationDTO.setEndDateFormatted(
                    f.format(reservation.getEndDate())
            );

            reservationDTOList.add(reservationDTO);
        }


        // return the list.
        return reservationDTOList;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ReservationDTO post(@RequestBody ReservationDTO reservationDTO) {

        Guest foundGuest;
        Room foundRoom;
        Reservation reservation = new Reservation();

        // find guestobject by id >> add to reservation.
        System.out.println(reservationDTO.getGuestId());
        foundGuest = guestRepository.findOne(reservationDTO.getGuestId());
        System.out.println(foundGuest);

        // find roomobject by id >> add to reservation.
        foundRoom = roomRepository.findOne(reservationDTO.getRoomId());
        System.out.println(foundRoom);

        //Mapping
        //reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setStartDate(LocalDateTime.now());
        //reservation.setEndDate(reservationDTO.getEndDate());
        reservation.setEndDate(LocalDateTime.now());
        reservation.setPayment(reservationDTO.isPayment());
        if (reservationDTO.getReservationNumber() != null) {
            reservation.setReservationNumber(reservationDTO.getReservationNumber());
        }
        reservation.setGuest(foundGuest);
        reservation.setRoom(foundRoom);

        // Save to repository
        reservationRepository.save(reservation);
        return reservationDTO;
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.GET)
    public Reservation get(@PathVariable long reservationNumber){
        return reservationRepository.findOne(reservationNumber);
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.PUT)
    public Reservation put (@RequestBody Reservation reservation, @PathVariable long reservationNumber){
        reservationRepository.save(reservation);
        return reservationRepository.findOne(reservation.getReservationNumber());
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable long reservationNumber){
        reservationRepository.delete(reservationNumber);
        return !reservationRepository.exists(reservationNumber);
    }



}
