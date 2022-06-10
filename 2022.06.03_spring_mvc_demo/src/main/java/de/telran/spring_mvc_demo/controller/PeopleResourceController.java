package de.telran.spring_mvc_demo.controller;

import de.telran.spring_mvc_demo.model.Person;
import de.telran.spring_mvc_demo.repo.PersonRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/people")
public class PeopleResourceController {

    private PersonRepo personRepo;

    public PeopleResourceController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    public List<Person> getAll(){
        return personRepo.getSource();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        personRepo.add(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return personRepo.getById(id);
    }
}
