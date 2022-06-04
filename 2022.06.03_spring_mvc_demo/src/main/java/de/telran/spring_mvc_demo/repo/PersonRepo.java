package de.telran.spring_mvc_demo.repo;

import de.telran.spring_mvc_demo.model.Person;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class PersonRepo {

    private List<Person> source = new ArrayList<>();

    public PersonRepo() {
    }

    public List<Person> getSource() {
        return source;
    }

    public void add(Person person){
        source.add(person);
    }
}
