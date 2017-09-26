package com.capgemini.hotel.core.model;

import java.time.LocalDateTime;

public class Reservation {

    private Guest guest;
    private Room room;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean payment;

    public Room getRoom() {
        return room;
    }
}
