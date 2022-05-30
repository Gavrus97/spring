package de.telran.hello_web.controller;

import de.telran.hello_web.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//let spring know that this is a controller to place it into mvc configuration
@Controller
public class HelloController {

    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    // to return a simple String in the http response body
    @ResponseBody
    public String helloWorld(){
        return "Hello world !";
    }

    // the same as @RequestMapping but with specified http method GET
    // to serve all requests like "/hello/Vasya", "/hello/Petja", "/hello/somebody"...
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "Hello " + name + " !";
    }

    @GetMapping("/hello-thymeleaf/{name}")
    public String helloThymeleaf(@PathVariable String name, Model model){
        model.addAttribute("nameToShow",name );
        return "hello";
    }

    @PostMapping("/post-hello")
    @ResponseBody
    public String postHello(@ModelAttribute Person person){
        return "name " + person.getName() + " last name " + person.getLastname();
    }

}
