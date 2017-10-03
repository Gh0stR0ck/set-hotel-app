package com.capgemini.hotel.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class GuestManagerTest {

private Hotel hotel;

    @Before
    public void init(){
        // initialise
         hotel = new Hotel();
    }

    @Test
    public void addGuest(){
        Guest guest = new Guest("aap", null, null, null, null, null, null, null);
        hotel.guestManager.addGuest(guest);
        assertTrue(hotel.guestManager.getGuestList().contains(guest));

        guest = new Guest("aap", "Surname", null, null, null, null, null, null);

        hotel.guestManager.addGuest(guest);
        assertTrue(hotel.guestManager.getGuestList().contains(guest));

    }


    @Test
    public void getGuest(){

        // maak guest aan
        Guest guest = new Guest("aap", null, null, null, null, null, null, null);
        hotel.guestManager.addGuest(guest);

        // haal auto increment id op
        int currentId = Guest.getCount().get();
        System.out.println(currentId);

        // getGuest met id. --currentId because of the AtomicInteger type.
//        Guest resultGuest = hotel.guestManager.getGuest(--currentId);
//        System.out.println(resultGuest.getGuestNumber());
//        assertTrue(resultGuest.getGuestNumber() == currentId);
//
//        // getguest met id 500 (bestaat niet)
//        resultGuest = hotel.guestManager.getGuest(500);
//        assertTrue(resultGuest == null);

    }



}