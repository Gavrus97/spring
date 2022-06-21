package de.telran.building_demo.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "building")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Building {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "floors_count")
    private Integer floorsCount;
}
