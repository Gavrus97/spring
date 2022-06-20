package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class OwnerRequestDTO {

    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;

}
