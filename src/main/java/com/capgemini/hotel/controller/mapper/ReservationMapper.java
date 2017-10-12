package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.controller.dto.ReservationDTO;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationMapper {

    private static final String PRESENTATION_DATE_FORMAT = "dd/MM/yy";
    private static final String OBJECT_DATE_FORMAT = "dd/MM/yy'T'HH:mm";
    private static final DateTimeFormatter fPresentation = DateTimeFormatter.ofPattern(PRESENTATION_DATE_FORMAT);
    private static final DateTimeFormatter fObject = DateTimeFormatter.ofPattern(OBJECT_DATE_FORMAT);

    //
    //
    //

    public static ReservationDTO map(Reservation reservation) {

        final ReservationDTO reservationDTO = new ReservationDTO();

        if (reservation.getReservationNumber() != null) {
            reservationDTO.setReservationNumber(
                    reservation.getReservationNumber()
            );
        }

        if (reservation.getGuest() != null) {
            reservationDTO.setGuestId(
                    reservation.getGuest().getGuestNumber()
            );
            reservationDTO.setGuestName(
                    reservation.getGuest().getName() +
                            " " +
                            reservation.getGuest().getSurname()
            );
        }
        if (reservation.getRoom() != null) {
            if (reservation.getRoom().getRoomNumber() != null) {
                reservationDTO.setRoomId(
                        reservation.getRoom().getRoomNumber()
                );
            }
            reservationDTO.setRoomName(
                    reservation.getRoom().getRoomName()
            );
        }
        if (reservation.getStartDate() != null) {
            reservationDTO.setStartDateFormatted(fObject.format(reservation.getStartDate()));
            reservationDTO.setStartDatePresentation(fPresentation.format(reservation.getStartDate()));
        }
        if (reservation.getEndDate() != null) {
            reservationDTO.setEndDateFormatted(fObject.format(reservation.getEndDate()));
            reservationDTO.setEndDatePresentation(fPresentation.format(reservation.getEndDate()));
        }
        reservationDTO.setPayment(reservation.isPayment());


        return reservationDTO;
    }

    //
    //
    //
    //
    //

    public static Reservation map(ReservationDTO reservationDTO) {

        final Reservation reservation = new Reservation();


        if (reservationDTO.getReservationNumber() != null) {
            reservation.setReservationNumber(
                    reservationDTO.getReservationNumber()
            );
        }
        reservation.setPayment(reservationDTO.isPayment());

        if (reservationDTO.getStartDateFormatted() != null) {
            reservation.setStartDate(
                    LocalDateTime.parse(reservationDTO.getStartDateFormatted(), fObject)
            );
        }
        if (reservationDTO.getEndDateFormatted() != null) {
            reservation.setEndDate(
                    LocalDateTime.parse(reservationDTO.getEndDateFormatted(), fObject)
            );
        }

        return reservation;
    }
}
