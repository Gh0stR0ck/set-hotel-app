package com.capgemini.hotel.controller;

import com.capgemini.hotel.controller.dto.ReservationDTO;
import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private Reservation mockReservation;

    @Test
    public void getAll() throws Exception {
        // mockwaarde
        final List<Reservation> mockReservationList = new ArrayList<>();
        mockReservationList.add(mockReservation);
        when(reservationRepository.findAll()).thenReturn(mockReservationList);

        when(mockReservation.getReservationNumber()).thenReturn(1L);
        when(mockReservation.getGuest()).thenReturn(new Guest());
        when(mockReservation.getRoom()).thenReturn(new Room());
        when(mockReservation.getStartDate()).thenReturn(LocalDateTime.now());
        when(mockReservation.getEndDate()).thenReturn(LocalDateTime.now());
        when(mockReservation.isPayment()).thenReturn(true);


        // Repository lijst met Reservations
        final Iterable<ReservationDTO> ReservationDTOList = reservationController.getAll();

        // Check of Reservation repo aangeroepen
        verify(reservationRepository, times(1)).findAll();

        // Resultaat van controller overeenkomt met mock-waarde
        assertEquals(1, ReservationDTOList.spliterator().getExactSizeIfKnown());

        // Check dateformatter in DTO


        // Wat verwacht je van je DTO obv mockwaarden?

    }

}