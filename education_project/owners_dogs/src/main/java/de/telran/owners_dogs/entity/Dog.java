package de.telran.owners_dogs.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Dog")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "breed")
    private String breed;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;


    @ManyToOne
    private Owner owner;

    @Column(name = "registrationDate")
    private LocalDate registrationDate;

}
