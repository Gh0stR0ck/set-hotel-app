package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}

