package de.telran.spring_mvc_demo.controller;

import de.telran.spring_mvc_demo.model.Person;
import de.telran.spring_mvc_demo.repo.PersonRepo;
import de.telran.spring_mvc_demo.webmodel.PeopleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping("/people")
    public String getIndexForm(Model model){
        model.addAttribute("peopleForm", new PeopleForm());
        model.addAttribute("people", personRepo.getSource());
        return "persons";
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, PeopleForm peopleForm){
        Person person = new Person(peopleForm.getFirstName(), peopleForm.getLastName());
        personRepo.add(person);
        model.addAttribute("people", personRepo.getSource());
        return "persons";
    }

}
