package com.capgemini.hotel.core.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class RoomManagerTest {

    @Before
    public void init(){
        // initialise
        RoomManager roomManager = new RoomManager();

        Guest guest = new Guest(1, null, null, null, null, null, null, null, null);

        roomManager.addGuest(guest);
    }

    @Test
    public void searchGuestTest(){

        // Ramon test

    }


}