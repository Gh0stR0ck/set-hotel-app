package com.capgemini.hotel.controller.mapper;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.controller.dto.ReservationDTO;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationMapper {

    private static final String DTO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'";
    private static final DateTimeFormatter f = DateTimeFormatter.ofPattern(DTO_DATE_FORMAT);

    //
    //
    //

    public static ReservationDTO map(Reservation reservation) {

        final ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setStartDate(
                reservation.getStartDate()
        );
        reservationDTO.setEndDate(
                reservation.getEndDate()
        );

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
            reservationDTO.setStartDateFormatted(f.format(reservation.getStartDate()));
        }
        if (reservation.getEndDate() != null) {
            reservationDTO.setEndDateFormatted(f.format(reservation.getEndDate()));
        }

        return reservationDTO;
    }

    //
    //
    //
    //
    //

    public static Reservation map(ReservationDTO reservationDTO) {

        final Reservation reservation = new Reservation();

        reservation.setEndDate(
                reservationDTO.getEndDate()
        );

        if (reservationDTO.getReservationNumber() != null) {
            reservation.setReservationNumber(
                    reservationDTO.getReservationNumber()
            );
        }

        if (reservationDTO.getStartDateFormatted() != null) {

            reservation.setStartDate(
                    // format to appropriate date
                    LocalDateTime.parse(reservationDTO.getStartDateFormatted(), f)
            );
        }

        return reservation;
    }
}
