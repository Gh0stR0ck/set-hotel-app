package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservations")
public class ReservationController {

    @Autowired
    ReservationRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Reservation> getAll(){
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Reservation post (@RequestBody Reservation reservation){
        repository.save(reservation);
        return repository.findOne(reservation.getReservationNumber());
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.GET)
    public Reservation get(@PathVariable long reservationNumber){
        return repository.findOne(reservationNumber);
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.PUT)
    public Reservation put (@RequestBody Reservation reservation, @PathVariable long reservationNumber){
        repository.save(reservation);
        return repository.findOne(reservation.getReservationNumber());
    }

    @RequestMapping(value = "/{reservationNumber}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable long reservationNumber){
        repository.delete(reservationNumber);
        return !repository.exists(reservationNumber);
    }



}
