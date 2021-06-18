package com.politechnika.Projekt_UDPJEE.repository;

import com.politechnika.Projekt_UDPJEE.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
