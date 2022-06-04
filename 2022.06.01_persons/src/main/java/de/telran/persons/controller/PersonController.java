package de.telran.persons.controller;

import de.telran.persons.model.Person;
import de.telran.persons.sevice.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("persons", personService.getAll());
        return "index";
    }

    @GetMapping("/show{id}")
    public String getByIndex(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.get(id));
        return "show-person";
    }

    @GetMapping("/new-person")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "add-person";
    }

    @PostMapping("/save-person")
    public String savePerson(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/edit{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.get(id));
        return "person-edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") Person person){
        personService.save(person);
        return "redirect:/";
    }

    @PostMapping("/delete{id}")
    public String delete(@PathVariable("id") int id){
        personService.remove(personService.get(id));
        return "redirect:/";
    }




}
