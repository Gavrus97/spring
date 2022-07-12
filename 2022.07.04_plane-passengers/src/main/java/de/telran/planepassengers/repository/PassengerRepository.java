package de.telran.planepassengers.repository;

import de.telran.planepassengers.entity.PassengerTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<PassengerTicket, Long> {
}
