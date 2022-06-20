package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class DogResponseDTO {

    public String nickname;
    public String breed;
    public Integer ownerId;
    public LocalDate registrationDate;
}
