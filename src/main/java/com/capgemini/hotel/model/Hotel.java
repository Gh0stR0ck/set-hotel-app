package com.capgemini.hotel.model;


public class Hotel {

    public final GuestManager guestManager;
    public final RoomManager roomManager;
    public final ReservationManager reservationManager;

    public Hotel() {
        this.guestManager = new GuestManager();
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();
    }

}
