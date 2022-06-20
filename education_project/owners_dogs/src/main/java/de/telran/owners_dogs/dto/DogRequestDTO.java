package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DogRequestDTO {

    public String nickname;
    public String breed;
    public LocalDate dateOfBirth;
}
