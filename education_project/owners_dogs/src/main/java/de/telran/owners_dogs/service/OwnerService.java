package de.telran.owners_dogs.service;

import de.telran.owners_dogs.dto.OwnerRequestDTO;
import de.telran.owners_dogs.dto.OwnerResponseDTO;

import java.util.List;

public interface OwnerService {

    void create(OwnerRequestDTO ownerDto);

    OwnerResponseDTO getById(Integer id);

    void edit(Integer id, OwnerRequestDTO ownerDto);

    void toggleDogOwner(Integer ownerId, Integer dogId);

    List<OwnerResponseDTO> getAll();
}
