package de.telran.apartmentproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees; //жто поле не создается, hibernate идет в таблицу employee
                                      // и спрашивает у них в какой компании они работают


}
