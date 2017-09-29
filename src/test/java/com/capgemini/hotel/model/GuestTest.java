package com.capgemini.hotel.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class GuestTest {

private Hotel hotel;

    @Before
    public void init(){
    }

    @Test
    public void newGuest(){
        Guest guest = new Guest(null, null, null, null, null, null, null, null);
        assertEquals(0, guest.getGuestNumber());

        guest = new Guest("Surname", null, null, null, null, null, null, null);
        assertEquals(1, guest.getGuestNumber());

    }


}