package de.telran.persons_rest.controller;

import de.telran.persons_rest.dto.AddressDto;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * get Person by id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Integer id) {
        return addressService.get(id);
    }

    /**
     * create a new person
     */
    @PostMapping
    public AddressDto create(@RequestBody AddressDto address) {
        return addressService.create(address);
    }

    @PutMapping
    public void edit(@RequestBody AddressDto address) {
        addressService.edit(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.remove(id);
    }

    @GetMapping
    public List<AddressDto> getAll(@RequestParam(required = false) Optional<Integer> personId) {
        return addressService.getAllByPersonId(personId);
    }
}
