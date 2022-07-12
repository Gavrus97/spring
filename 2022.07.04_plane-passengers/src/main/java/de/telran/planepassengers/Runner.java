package de.telran.planepassengers;

import de.telran.planepassengers.entity.PassengerTicket;
import de.telran.planepassengers.entity.type.TicketType;
import de.telran.planepassengers.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private PassengerRepository repository;

    @Override
    public void run(String... args) throws Exception {

        PassengerTicket passenger = PassengerTicket
                .builder()
                .ticketType(TicketType.BUSINESS)
                .name("John")
                .build();

        PassengerTicket passenger2 = PassengerTicket
                .builder()
                .ticketType(TicketType.ECONOMY)
                .name("Mary")
                .build();

        PassengerTicket passenger3 = PassengerTicket
                .builder()
                .ticketType(TicketType.VIP)
                .name("Oleg")
                .build();

        repository.saveAll(List.of(passenger,passenger2,passenger3));
    }
}
