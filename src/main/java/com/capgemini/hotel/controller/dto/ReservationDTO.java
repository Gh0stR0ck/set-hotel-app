package com.capgemini.hotel.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ReservationDTO {

    private Long reservationNumber;
    @NotNull(message = "Guest must be specified.")
    private Long guestId;
    @NotNull(message = "Room must be specified.")
    private Long roomId;


    @NotEmpty(message = "Payment must be specified.")
    private String payment;

    // used for incoming String Input & outgoing formatted text.
    @NotEmpty(message = "Date must be specified.")
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

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
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
}