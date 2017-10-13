package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.capgemini.hotel.App.db;


@RestController
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value = "/api/guest" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Guest> guestList() {
        return guestRepository.findAll();
    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.POST)
    public Guest process(@Valid @RequestBody Guest guest) {

        guestRepository.save(guest);
        return guest;
    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.DELETE)
    public Guest deleteGuest(@RequestBody Guest guest) {

        guestRepository.delete(guest);
        return guest;
    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.PUT)
    public Guest updateGuest(@Valid @RequestBody Guest guest) {

        guestRepository.save(guest);
        return guest;
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