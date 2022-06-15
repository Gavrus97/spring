package de.telran.persons_rest.controller;

import de.telran.persons_rest.dto.PersonDto;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * get Person by id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public PersonDto get(@PathVariable Integer id) {
        return personService.get(id);
    }

    /**
     * create a new person
     */
    @PostMapping
    public PersonDto create(@RequestBody PersonDto person) {
        return personService.save(person);
    }

    @PutMapping
    public void edit(@RequestBody PersonDto person) {
        personService.edit(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.remove(id);
    }

    @GetMapping
    public List<PersonDto> getAll(@RequestParam(required = false) Optional<String>name,
                               @RequestParam(required = false)Optional<String> lastName) {
        return personService.findByNameAndLastName(name,lastName);
    }


    @GetMapping("/find-by-age")
    public List<PersonDto> findByAge(@RequestParam("number") int number) {
        return personService.findByAge(number);
    }
}
