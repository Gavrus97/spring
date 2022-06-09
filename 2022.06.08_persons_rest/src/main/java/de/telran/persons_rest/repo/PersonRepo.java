package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonRepo {

    private int currentId = 0;
    private final Map<Integer, Person> source;
    {
        source = new HashMap<>();
        Person p1 = new Person("Vasja", "Pupkin", 20);
        p1.setId(++currentId);
        source.put(currentId, p1);

        Person p2 = new Person("Petja", "Vaskin", 30);
        p2.setId(++currentId);
        source.put(currentId, p2);
    }


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
     * @param id of person
     * @return person
     */
    public Person delete(int id) {
        return source.remove(id);
    }

    /**
     * finds the person with this id and returns if exists. Otherwise, returns empty Optional
     *
     * @param id of person
     * @return optional
     */
    public Optional<Person> find(int id) {
        return Optional.ofNullable(source.get(id));
    }

    /**
     * @return a List of all persons in source
     */
    public List<Person> findAll() {
        return source
                .values()
                .stream()
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.toList());
    }



}
