package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OwnerResponseDTO {

    public String name;
    public String lastName;
    public List<DogResponseDTO> dogs;

}
