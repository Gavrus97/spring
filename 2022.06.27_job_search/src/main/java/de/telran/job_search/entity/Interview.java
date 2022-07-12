package de.telran.job_search.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "interview")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
