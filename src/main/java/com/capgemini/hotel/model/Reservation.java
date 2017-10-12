package com.capgemini.hotel.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationNumber;
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Room room;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean payment;

    public Reservation() {

    }

    public Reservation(Guest guest, Room room, LocalDateTime startDate, LocalDateTime endDate, boolean payment) {
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
    }

    public Long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(Long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean isPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }
}