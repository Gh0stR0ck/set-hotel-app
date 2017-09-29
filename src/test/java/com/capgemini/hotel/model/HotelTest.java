package com.capgemini.hotel.model;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class HotelTest {

    @Before
    public void init(){
        // initialise
        Hotel hotel = new Hotel();

        Guest guest = new Guest( null, null, null, null, null, null, null, null);

        hotel.guestManager.addGuest(guest);
    }

    @Test
    public void searchGuestTest(){

        // Ramon test

    }


}