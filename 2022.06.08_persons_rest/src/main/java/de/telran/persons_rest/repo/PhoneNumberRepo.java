package de.telran.persons_rest.repo;

import de.telran.persons_rest.dto.PhoneNumberDto;
import de.telran.persons_rest.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {
     List<PhoneNumber> findAllByPersonId(Integer integer);
}
