package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DogRequestDTO {

    private String nickname;
    private String breed;
    private LocalDate dateOfBirth;
}
