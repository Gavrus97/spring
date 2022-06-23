package de.telran.owners_dogs.service.impl;

import de.telran.owners_dogs.dto.OwnerRequestDTO;
import de.telran.owners_dogs.dto.OwnerResponseDTO;
import de.telran.owners_dogs.entity.Dog;
import de.telran.owners_dogs.entity.Owner;
import de.telran.owners_dogs.repository.DogRepository;
import de.telran.owners_dogs.repository.OwnerRepository;
import de.telran.owners_dogs.service.DogService;
import de.telran.owners_dogs.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository repository;

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogServiceImpl dogService;

    @Override
    public void create(OwnerRequestDTO ownerDto) {
        repository.save(createOwner(ownerDto));
    }

    @Override
    public OwnerResponseDTO getById(Integer id) {
        return createResponseDto(getOwnerFromRepositoryById(id));
    }

    @Override
    public void edit(Integer id, OwnerRequestDTO ownerDto) {
        Owner owner = getOwnerFromRepositoryById(id);
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        owner.setDateOfBirth(ownerDto.getDateOfBirth());

        repository.save(owner);
    }

    @Override
    public List<OwnerResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(this::createResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void toggleDogOwner(Integer ownerId, Integer dogId) {
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Owner owner = getOwnerFromRepositoryById(ownerId);

        if(dog.getOwner().getId() != null && !dog.getOwner().getId().equals(ownerId))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        dog.setOwner(dog.getOwner() == null ? owner : null);

        dog.setRegistrationDate(dog.getOwner() == null ? LocalDate.now() : null);

        dogRepository.save(dog);
    }

    // Creates an Owner using RequestDTO
    private Owner createOwner(OwnerRequestDTO ownerDto) {
        return Owner.builder()
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .dateOfBirth(ownerDto.getDateOfBirth())
                .build();
    }

    //Creates ResponseDTO using Owner
    private OwnerResponseDTO createResponseDto(Owner owner) {
        return OwnerResponseDTO.builder()
                .name(owner.getFirstName())
                .lastName(owner.getLastName())
                .build();
    }

    private Owner getOwnerFromRepositoryById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
