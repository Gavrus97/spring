package de.telran.owners_dogs.repository;

import de.telran.owners_dogs.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
