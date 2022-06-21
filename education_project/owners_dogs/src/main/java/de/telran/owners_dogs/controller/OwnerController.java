package de.telran.owners_dogs.controller;

import de.telran.owners_dogs.dto.OwnerRequestDTO;
import de.telran.owners_dogs.dto.OwnerResponseDTO;
import de.telran.owners_dogs.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @PostMapping("/owners")
    public void create(@RequestBody OwnerRequestDTO ownerDto){
        service.create(ownerDto);
    }

    @GetMapping("/owners")
    public List<OwnerResponseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/owners/{id}")
    public OwnerResponseDTO getOwnerById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/owners/{id}")
    public void editOwner(@PathVariable Integer id, @RequestBody OwnerRequestDTO ownerDto){
        service.edit(id, ownerDto);
    }

    @PutMapping("/owners/{id}/dogs/{dog_id}")
    public OwnerResponseDTO manipulateDogs(@PathVariable("id") Integer id, @PathVariable("dog_id") Integer dogId ){
        return service.addOrDeleteDog(id, dogId);
    }
}
