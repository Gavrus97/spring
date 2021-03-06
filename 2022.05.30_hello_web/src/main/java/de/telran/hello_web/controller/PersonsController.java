package de.telran.hello_web.controller;

import de.telran.hello_web.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class PersonsController {

    public List<Person> getPersons() {
        return Arrays.asList(
                new Person("Matwej", "Petrovich"),
                new Person("Petja", "Pupkin"),
                new Person("Masha", "Mashkina"),
                new Person("Olga", "Petrovna"));
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        model.addAttribute("listPersons", getPersons());
        return "person";
    }

    @GetMapping("/persons-json")
    @ResponseBody
    public List<Person> getPersonsJson(Model model){
        return getPersons();
    }
}
