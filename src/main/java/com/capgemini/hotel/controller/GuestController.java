package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.capgemini.hotel.App.db;

@RestController
public class GuestController {

    @RequestMapping(value = "/api/guest" , method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> guestList() {

        db.open();

        List<Guest> guestList = new ArrayList<>();
        ResultSet resultSet = db.query("SELECT * FROM hotel1.Guest");

        try {
            while (resultSet.next()) {
                Guest guestResult = new Guest(null,null,null,null,null,null,null,null);

                guestResult.setSurname(resultSet.getString("surname"));
                guestResult.setName(resultSet.getString("name"));
                guestResult.setAddress(resultSet.getString("address"));
                guestResult.setZipcode(resultSet.getString("zipcode"));
                guestResult.setCity(resultSet.getString("city"));
                guestResult.setCountry(resultSet.getString("country"));
                guestResult.setPhone(resultSet.getString("phone"));
                guestResult.setEmail(resultSet.getString("email"));

                guestList.add(guestResult);

            }
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                db.close();
            } catch (java.sql.SQLException e) {
                System.out.println(e);
            }
        }
        return guestList;

    }

    @RequestMapping(value= "/api/guest/Details/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Guest> guestDetails(@PathVariable("id") long id) {

        db.open();

        List<Guest> guestList = new ArrayList<>();
        ResultSet resultSet = db.query("SELECT * FROM hotel1.Guest WHERE idGuest =" + id + " ORDER BY idGuest DESC");

        try {
            while (resultSet.next()) {
                Guest guestResult = new Guest(null,null,null,null,null,null,null,null);

                guestResult.setSurname(resultSet.getString("surname"));
                guestResult.setName(resultSet.getString("name"));
                guestResult.setAddress(resultSet.getString("address"));
                guestResult.setZipcode(resultSet.getString("zipcode"));
                guestResult.setCity(resultSet.getString("city"));
                guestResult.setCountry(resultSet.getString("country"));
                guestResult.setPhone(resultSet.getString("phone"));
                guestResult.setEmail(resultSet.getString("email"));

                guestList.add(guestResult);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        } finally {
            try {
                resultSet.close();
                db.close();
            } catch (java.sql.SQLException e) {
                System.out.println(e);
            }
        }
        return guestList;
    }

    @RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
    public Guest process(@RequestBody Guest guest) {

        System.out.println("Incoming: " + guest.getName() + "\t" + guest.getSurname());
        db.open();

        String query = "INSERT INTO `hotel1`.`Guest` (" +
                "`surname`, " +
                "`name`, " +
                "`address`, " +
                "`zipcode`, " +
                "`city`, " +
                "`country`, " +
                "`phone`, " +
                "`email`" +
                ") VALUES (" +
                "'"+ guest.getSurname() + "'," +
                "'"+ guest.getName() + "'," +
                "'"+ guest.getAddress() + "'," +
                "'"+ guest.getZipcode() + "'," +
                "'"+ guest.getCity() + "'," +
                "'"+ guest.getCountry() + "'," +
                "'"+ guest.getPhone() + "'," +
                "'"+ guest.getEmail() + "');";
        try {
            db.execute(query);
            System.out.println(guest.toString());
            return guest;
        } finally {
            db.close();
        }
    }
}