package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class OwnerRequestDTO {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
