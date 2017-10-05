package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @RequestMapping(value= "/api/guest/Details/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Guest> guestDetails(@PathVariable("id") long id) {
//
//        db.open();
//
//        List<Guest> guestList = new ArrayList<>();
//        ResultSet resultSet = db.query("SELECT * FROM hotel1.Guest WHERE idGuest =" + id + " ORDER BY idGuest DESC");
//
//        try {
//            while (resultSet.next()) {
//                Guest guestResult = new Guest();
//
//                guestResult.setSurname(resultSet.getString("surname"));
//                guestResult.setName(resultSet.getString("name"));
//                guestResult.setAddress(resultSet.getString("address"));
//                guestResult.setZipcode(resultSet.getString("zipcode"));
//                guestResult.setCity(resultSet.getString("city"));
//                guestResult.setCountry(resultSet.getString("country"));
//                guestResult.setPhone(resultSet.getString("phone"));
//                guestResult.setEmail(resultSet.getString("email"));
//
//                guestList.add(guestResult);
//            }
//        } catch (java.sql.SQLException e) {
//            System.out.println(e);
//        } finally {
//            try {
//                resultSet.close();
//                db.close();
//            } catch (java.sql.SQLException e) {
//                System.out.println(e);
//            }
//        }
//        return guestList;
//    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.POST)
    public Guest process(@RequestBody Guest guest) {

        guestRepository.save(guest);
        return guest;
    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.DELETE)
    public Guest deleteGuest(@RequestBody Guest guest) {

        guestRepository.delete(guest);
        return guest;
    }

    @RequestMapping(value = "/api/guest", method = RequestMethod.PUT)
    public Guest updateGuest(@RequestBody Guest guest) {

        guestRepository.save(guest);
        return guest;
    }
}