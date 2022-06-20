package de.telran.owners_dogs.repository;

import de.telran.owners_dogs.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findAllByRegistrationDateIsNull();
}
