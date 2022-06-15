package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findAllByPersonId(Integer integer);
}
