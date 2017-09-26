package com.capgemini.hotel.model;


public class Hotel {

    public GuestManager guestManager;
    public RoomManager roomManager;
    public ReservationManager reservationManager;

    public Hotel() {
        this.guestManager = new GuestManager();
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();
    }

}
