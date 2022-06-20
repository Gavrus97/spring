package de.telran.owners_dogs.service;

import de.telran.owners_dogs.dto.OwnerRequestDTO;
import de.telran.owners_dogs.dto.OwnerResponseDTO;

import java.util.List;

public interface OwnerService {

    void create(OwnerRequestDTO ownerDto);

    OwnerResponseDTO getById(int id);

    void edit(int id, OwnerRequestDTO ownerDto);

    OwnerResponseDTO addOrDeleteDog(int id, int dogId);

    List<OwnerResponseDTO> getAll();
}
