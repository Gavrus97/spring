package de.telran.persons_rest.controller;

import de.telran.persons_rest.dto.PhoneNumberDto;
import de.telran.persons_rest.service.PhoneNumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phone-numbers")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }


    @GetMapping("/{id}")
    public PhoneNumberDto get(@PathVariable Integer id){
        return phoneNumberService.get(id);
    }

    @PutMapping
    public void edit(PhoneNumberDto phoneNumberDto){
        phoneNumberService.edit(phoneNumberDto);
    }

    @PostMapping
    public PhoneNumberDto create (@RequestBody PhoneNumberDto phoneNumberDto){
        return phoneNumberService.create(phoneNumberDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        phoneNumberService.remove(id);
    }

    @GetMapping
    public List<PhoneNumberDto> getAll(@RequestParam(required = false) Optional<Integer> personId){
        return phoneNumberService.getAllByPersonId(personId);
    }
}
