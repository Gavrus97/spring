package de.telran.persons.sevice;

import de.telran.persons.model.Person;
import de.telran.persons.repo.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person){
        return personRepo.save(person);
    }
}
