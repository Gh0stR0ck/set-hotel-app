package com.capgemini.hotel.controller;

import com.capgemini.hotel.controller.mapper.ReservationMapper;
import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.controller.dto.ReservationDTO;
import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.GuestRepository;
import com.capgemini.hotel.repository.ReservationRepository;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
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
        // instantiate returnlist
        ArrayList<ReservationDTO> reservationDTOList = new ArrayList<>();

        //  Iterate over the reservations and map
        for (Reservation reservation : reservationList) {
            ReservationDTO reservationDTO = ReservationMapper.map(reservation);
            reservationDTOList.add(reservationDTO);
        }

        // return the list.
        return reservationDTOList;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void post(@Valid @RequestBody ReservationDTO reservationDTO) {

        // eerst mappen
        Reservation reservation = new Reservation();
        reservation = ReservationMapper.map(reservationDTO);

        // guest en room ophalen --> Servicelaag.
        Guest foundGuest;
        Room foundRoom;


        // find guestobject by id >> add to reservation.
        foundGuest = guestRepository.findOne(reservationDTO.getGuestId());
        reservation.setGuest(foundGuest);

        // find roomobject by id >> add to reservation.
        foundRoom = roomRepository.findOne(reservationDTO.getRoomId());
        reservation.setRoom(foundRoom);

        // Save to repository
        reservationRepository.save(reservation);
        return;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody ReservationDTO reservationDTO) {

        // eerst mappen
        Reservation reservation = new Reservation();
        reservation = ReservationMapper.map(reservationDTO);

        // guest en room ophalen --> Servicelaag.
        Guest foundGuest;
        Room foundRoom;


        // find guestobject by id >> add to reservation.
        foundGuest = guestRepository.findOne(reservationDTO.getGuestId());
        reservation.setGuest(foundGuest);

        // find roomobject by id >> add to reservation.
        foundRoom = roomRepository.findOne(reservationDTO.getRoomId());
        reservation.setRoom(foundRoom);

        // Save to repository
        reservationRepository.save(reservation);
        return;
    }


    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@RequestBody ReservationDTO reservationDTO) {

        // eerst mappen
        Reservation reservation = new Reservation();
        reservation = ReservationMapper.map(reservationDTO);

        // guest en room ophalen --> Servicelaag.
        Guest foundGuest;
        Room foundRoom;


        // find guestobject by id >> add to reservation.
        foundGuest = guestRepository.findOne(reservationDTO.getGuestId());
        reservation.setGuest(foundGuest);

        // find roomobject by id >> add to reservation.
        foundRoom = roomRepository.findOne(reservationDTO.getRoomId());
        reservation.setRoom(foundRoom);

        // Save to repository
        reservationRepository.delete(reservation);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ArrayList<String> errors = new ArrayList<>();
        for (FieldError field : fieldErrors){
            errors.add(field.getDefaultMessage());
        }
        return errors;
    }
}
