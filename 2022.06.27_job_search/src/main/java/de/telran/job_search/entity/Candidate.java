package de.telran.job_search.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
