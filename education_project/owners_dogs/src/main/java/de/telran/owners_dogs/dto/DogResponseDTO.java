package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class DogResponseDTO {

    private String nickname;
    private String breed;
    private Integer ownerId;
    private LocalDate registrationDate;
}
