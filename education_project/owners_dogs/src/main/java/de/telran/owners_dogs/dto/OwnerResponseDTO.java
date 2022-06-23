package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OwnerResponseDTO {

    private String name;
    private String lastName;
    private List<DogResponseDTO> dogs;

}
