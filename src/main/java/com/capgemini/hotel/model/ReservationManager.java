package com.capgemini.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {

    private List<Reservation> reservationList;

    public ReservationManager() {
        this.reservationList = new ArrayList<>();
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }



}
