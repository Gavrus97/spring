package de.telran.owners_dogs.service;

import de.telran.owners_dogs.dto.DogRequestDTO;
import de.telran.owners_dogs.dto.DogResponseDTO;
import de.telran.owners_dogs.entity.Dog;

import java.util.List;

public interface DogService {

    void create (DogRequestDTO dogDto);

    List<DogResponseDTO> findAll();

    List<DogResponseDTO> findUnregistered();

    void deleteAll();

    void edit(Integer id, DogRequestDTO dogDto);

   Dog getDogById(Integer id);
}
