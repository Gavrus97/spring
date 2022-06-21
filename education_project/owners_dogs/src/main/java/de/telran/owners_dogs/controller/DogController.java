package de.telran.owners_dogs.controller;

import de.telran.owners_dogs.dto.DogRequestDTO;
import de.telran.owners_dogs.dto.DogResponseDTO;
import de.telran.owners_dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DogController {

    @Autowired
    private DogService service;

    @PostMapping("/dogs")
    public void create(@RequestBody DogRequestDTO dogDto){
        service.create(dogDto);
    }

    @GetMapping("/dogs/unregistered")
    public List<DogResponseDTO> getUnregistered(){
        return service.findUnregistered();
    }

    @GetMapping("/dogs")
    public List<DogResponseDTO> getAll(){
        return service.findAll();
    }

    @DeleteMapping("/dogs")
    public void delete(){
        service.deleteAll();
    }

    @PutMapping("/dogs/{id}")
    public void edit(@PathVariable Integer id, @RequestBody DogRequestDTO dogDto){
        service.edit(id, dogDto);
    }
}
