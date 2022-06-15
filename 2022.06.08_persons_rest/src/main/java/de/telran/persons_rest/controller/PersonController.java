package de.telran.persons_rest.controller;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Person get(@PathVariable Integer id) {
        return personService.get(id);
    }

    /**
     * create a new person
     */
    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping
    public void edit(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.remove(id);
    }

    @GetMapping
    public List<Person> getAll(@RequestParam(required = false) Optional<String>name,
                               @RequestParam(required = false)Optional<String> lastName) {
        return personService.findByNameAndLastName(name,lastName);
    }


    @GetMapping("/find-by-age")
    public List<Person> findByAge(@RequestParam("number") int number) {
        return personService.findByAge(number);
    }
    // TODO create an endpoint, finding all persons with such a name. /api/persons?name=Vasya&lastname=Vasin
    // TODO create an endpoint, finding all persons with such a lastname
    // TODO create an endpoint finding all persons with the age larger some query parameter
}
