package com.capgemini.hotel.controller.dto;

import javax.persistence.*;
import java.time.LocalDateTime;


public class ReservationDTO {

    private Long reservationNumber;
    private long guestId;
    private long roomId;

    private boolean payment;

    // used for incoming String Input & outgoing formatted text.
    private String startDateFormatted;
    private String endDateFormatted;

    private String startDatePresentation;
    private String endDatePresentation;


    //only used for readability outgoing.
    private String guestName;
    private String roomName;

    public ReservationDTO() {

    }

    public Long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(Long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public String getStartDateFormatted() {
        return startDateFormatted;
    }

    public void setStartDateFormatted(String startDateFormatted) {
        this.startDateFormatted = startDateFormatted;
    }

    public String getEndDateFormatted() {
        return endDateFormatted;
    }

    public void setEndDateFormatted(String endDateFormatted) {
        this.endDateFormatted = endDateFormatted;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getStartDatePresentation() {
        return startDatePresentation;
    }

    public void setStartDatePresentation(String startDatePresentation) {
        this.startDatePresentation = startDatePresentation;
    }

    public String getEndDatePresentation() {
        return endDatePresentation;
    }

    public void setEndDatePresentation(String endDatePresentation) {
        this.endDatePresentation = endDatePresentation;
    }
}