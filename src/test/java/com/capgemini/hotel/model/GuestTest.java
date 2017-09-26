package com.capgemini.hotel.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;


public class GuestTest {

    @Before
    public void init(){
        // initialise
    }

    @Test
    public void newGuest(){
        Guest guest = new Guest(1, null, null, null, null, null, null, null, null);
        assertNotNull(guest);

    }



}