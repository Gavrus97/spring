package de.telran.spring_mvc_demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

//    @GetMapping("/")
//    public String getHomePage(){
//        return "index";
//    }

    @GetMapping("/dear-user")
    public String dearUser(){
        return "dear-user";
    }

    @GetMapping("/dear-{name}")
    public String getResponseWithName(@PathVariable String name, Model model){
        model.addAttribute("nameToShow", name);
        return "dear-name";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false,defaultValue = "User") String name,
                           Model model){
        model.addAttribute("name", name);
        return "greeting";
    }

}
