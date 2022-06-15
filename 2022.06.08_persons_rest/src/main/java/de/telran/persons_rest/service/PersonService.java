package de.telran.persons_rest.service;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Person remove(int id) {
        Person person = get(id);
        personRepo.delete(person);
        return person;
    }

    public Person get(int id){
        return personRepo.findById(id).orElseThrow();
    }

    public List<Person> findByNameAndLastName(Optional<String> name, Optional<String> lastName){
        if(name.isPresent() && lastName.isPresent())
            return personRepo.findAllByNameIgnoreCaseAndLastnameIgnoreCase(name.get(), lastName.get());
        if(name.isPresent())
            return personRepo.findAllByNameIgnoreCase(name.get());
        if(lastName.isPresent())
            return personRepo.findAllByLastnameIgnoreCase(lastName.get());
        return personRepo.findAll();
    }

    public List<Person> findByAge(int number){
        return personRepo.findAllByAgeGreaterThan(number);
    }
}
