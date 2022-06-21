package de.telran.owners_dogs.service.impl;

import de.telran.owners_dogs.dto.OwnerRequestDTO;
import de.telran.owners_dogs.dto.OwnerResponseDTO;
import de.telran.owners_dogs.entity.Dog;
import de.telran.owners_dogs.entity.Owner;
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
    OwnerRepository repository;

    @Autowired
    DogService dogService;

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
        owner.setFirstName(ownerDto.firstName);
        owner.setLastName(ownerDto.lastName);
        owner.setDateOfBirth(ownerDto.dateOfBirth);

        repository.save(owner);
    }

    @Override
    public List<OwnerResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(this::createResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponseDTO addOrDeleteDog(Integer id, Integer dogId) {
        Dog dog = dogService.getDogById(dogId);
        Owner dogOwner = dog.getOwner();
        Owner owner = getOwnerFromRepositoryById(id);

        if (dogOwner == null) {
            dog.setOwner(owner);
            dog.setRegistrationDate(LocalDate.now());
            owner.getDogs().add(dog);
        }
        else if(dogOwner.getId().equals(owner.getId())){
            dog.setOwner(null);
            dog.setRegistrationDate(null);
            owner.getDogs().remove(dog);
        }
        else if(!dogOwner.getId().equals(owner.getId())){
            dogOwner.getDogs().remove(dog);
            dog.setOwner(owner);
            dog.setRegistrationDate(LocalDate.now());
            owner.getDogs().add(dog);
        }

        repository.save(owner);
        return createResponseDto(owner);
    }

    // Creates an Owner using RequestDTO
    private Owner createOwner(OwnerRequestDTO ownerDto) {
        return Owner.builder()
                .firstName(ownerDto.firstName)
                .lastName(ownerDto.lastName)
                .dateOfBirth(ownerDto.dateOfBirth)
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
