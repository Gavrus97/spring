package de.telran.owners_dogs.service.implementation;

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
        repository.save(makeDogFromDto(dogDto));
    }

    @Override
    public List<DogResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::makeResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DogResponseDTO> findUnregistered() {
        return repository.findAllByRegistrationDateIsNull()
                .stream()
                .map(this::makeResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void edit(int id, DogRequestDTO dogDto) {
        Dog dog = makeDogFromDto(dogDto);
        dog.setId(id);
        repository.save(dog);
    }

    @Override
    public Dog getDogById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private Dog makeDogFromDto(DogRequestDTO dogDto){
        return Dog.builder()
                .nickname(dogDto.nickname)
                .breed(dogDto.breed)
                .dateOfBirth(dogDto.dateOfBirth)
                .registrationDate(null)
                .owner(null)
                .build();
    }

    private DogResponseDTO makeResponseDto(Dog dog){
        return DogResponseDTO.builder()
                .nickname(dog.getNickname())
                .breed(dog.getBreed())
                .build();
    }
}
