package de.telran.spring_mvc_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/dear-user")
    public String dearUser(){
        return "dear-user";
    }

    @GetMapping("/dear-{name}")
    public String getResponseWithName(@PathVariable String name){
        return "dear-name";
    }
}
