package de.telran.persons_rest.service;

import de.telran.persons_rest.dto.PersonDto;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public PersonDto save(PersonDto person) {
        Person pers = new Person(
                person.name,
                person.lastname,
                person.age
        );
        return mapPersonToDto(personRepo.save(pers));
    }

    public void edit(PersonDto person) {
        Person temp = personRepo.findById(person.id).orElseThrow();
        temp.setName(person.name);
        temp.setLastname(person.lastname);
        temp.setAge(person.age);
        personRepo.save(temp);
    }

    private PersonDto mapPersonToDto(Person person) {
        return new PersonDto(
                person.getId(),
                person.getName(),
                person.getLastname(),
                person.getAge()
        );
    }

    public void remove(int id) {
        personRepo.deleteById(id);
    }

    public PersonDto get(int id) {
        return personRepo.findById(id)
                .map(this::mapPersonToDto)
                .orElseThrow();
    }

    public List<PersonDto> findByNameAndLastName(Optional<String> name, Optional<String> lastName) {
        List<Person> persons;
        if (name.isPresent() && lastName.isPresent())
            persons = personRepo.findAllByNameIgnoreCaseAndLastnameIgnoreCase(name.get(), lastName.get());
        if (name.isPresent())
            persons = personRepo.findAllByNameIgnoreCase(name.get());
        if (lastName.isPresent())
            persons = personRepo.findAllByLastnameIgnoreCase(lastName.get());
        else
            persons = personRepo.findAll();

        return persons
                .stream()
                .map(this::mapPersonToDto)
                .collect(Collectors.toList());
    }

    public List<PersonDto> findByAge(int number) {
        return personRepo.findAllByAgeGreaterThan(number)
                .stream()
                .map(this::mapPersonToDto)
                .collect(Collectors.toList());
    }
}
