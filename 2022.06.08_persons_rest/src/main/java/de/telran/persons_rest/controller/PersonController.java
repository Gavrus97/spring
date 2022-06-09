package de.telran.persons_rest.controller;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /**
     * get Person by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Person get(@PathVariable Integer id){
        return personService.get(id);
    }

    /**
     * create a new person
     */
    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping
    public void edit(@RequestBody Person person){
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        personService.remove(personService.get(id));
    }

    @GetMapping
    public List<Person> getAll(){
        return personService.getAll();
    }

}
