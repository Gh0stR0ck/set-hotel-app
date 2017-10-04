package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
        }
