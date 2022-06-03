package de.telran.persons.repo;

import de.telran.persons.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PersonRepo {

    private int currentId = 0;
    private final Map<Integer, Person> source = new HashMap<>();


    /**
     * saves a new person or edits the old person
     *
     * @param person new person or existing person
     * @return saved person with assigned id
     */
    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(++currentId);
            source.put(currentId, person);
        }
            source.put(person.getId(), person);
            return person;
    }

    /**
     * removes the person with this id and returns it
     *
     * @param id
     * @return
     */
    public Person delete(int id) {
        return null;
    }

    /**
     * finds the person with this id and returns if exists. Otherwise returns empty Optional
     *
     * @param id
     * @return
     */
    public Optional<Person> find(int id) {
        return null;
    }

    /**
     * @return
     */
    public List<Person> findAll() {
        return null;
    }


}
