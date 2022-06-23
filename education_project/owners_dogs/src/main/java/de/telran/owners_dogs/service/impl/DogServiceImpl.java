package de.telran.owners_dogs.service.impl;

import de.telran.owners_dogs.dto.DogRequestDTO;
import de.telran.owners_dogs.dto.DogResponseDTO;
import de.telran.owners_dogs.entity.Dog;
import de.telran.owners_dogs.repository.DogRepository;
import de.telran.owners_dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository repository;

    @Override
    public void create(DogRequestDTO dogDto) {
        repository.save(convertToDogEntity(dogDto));
    }

    @Override
    public List<DogResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDogResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<DogResponseDTO> findUnregistered() {
        return repository.findAllByRegistrationDateIsNull()
                .stream()
                .map(this::convertToDogResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void edit(Integer id, DogRequestDTO dogDto) {
        Dog dog = getDogById(id);
        dog.setNickname(dogDto.getNickname());
        dog.setBreed(dogDto.getBreed());
        dog.setDateOfBirth(dogDto.getDateOfBirth());

        repository.save(dog);
    }

    @Override
    public Dog getDogById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Dog with id [%s] does not exist", id)));
    }

    private Dog convertToDogEntity(DogRequestDTO dogDto) {
        return Dog.builder()
                .nickname(dogDto.getNickname())
                .breed(dogDto.getBreed())
                .dateOfBirth(dogDto.getDateOfBirth())
                .registrationDate(null)
                .owner(null)
                .build();
    }

    protected DogResponseDTO convertToDogResponse(Dog dog) {
        return DogResponseDTO.builder()
                .nickname(dog.getNickname())
                .breed(dog.getBreed())
                .build();
    }
}
