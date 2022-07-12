package de.telran.planepassengers.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "flight")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;
}


