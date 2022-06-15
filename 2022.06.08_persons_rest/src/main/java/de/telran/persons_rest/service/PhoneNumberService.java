package de.telran.persons_rest.service;

import de.telran.persons_rest.dto.PhoneNumberDto;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.model.PhoneNumber;
import de.telran.persons_rest.repo.PersonRepo;
import de.telran.persons_rest.repo.PhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepo phoneNumberRepo;
    private final PersonRepo personRepo;

    public PhoneNumberService(PhoneNumberRepo phoneNumberRepo, PersonRepo personRepo) {
        this.phoneNumberRepo = phoneNumberRepo;
        this.personRepo = personRepo;
    }

    public PhoneNumberDto get(Integer id){
        return phoneNumberRepo.findById(id)
                .map(this::mapPhoneNumberToDto)
                .orElseThrow();

    }

    private PhoneNumberDto mapPhoneNumberToDto(PhoneNumber number) {
        return new PhoneNumberDto(
                number.getId(),
                number.getNumber(),
                number.getCountryCode(),
                number.getPerson().getId()
        );
    }

    public PhoneNumberDto create(PhoneNumberDto phoneNumberDto){
        Person person = personRepo.findById(phoneNumberDto.getPersonId()).orElseThrow();

        PhoneNumber number = new PhoneNumber(
                phoneNumberDto.id,
                phoneNumberDto.countryCode,
                phoneNumberDto.number,
                person
        );

        return mapPhoneNumberToDto(phoneNumberRepo.save(number));
    }

    public void edit(PhoneNumberDto phoneNumberDto){
        PhoneNumber number = phoneNumberRepo.findById(phoneNumberDto.id).orElseThrow();

        number.setNumber(phoneNumberDto.number);
        number.setCountryCode(phoneNumberDto.countryCode);

        phoneNumberRepo.save(number);
    }

    public void remove(int id){
        phoneNumberRepo.deleteById(id);
    }

    public List<PhoneNumberDto> getAllByPersonId(Optional<Integer> personId){
        List<PhoneNumber> numbers;
        if(personId.isPresent())
            numbers = phoneNumberRepo.findAllByPersonId(personId.get());
        else
            numbers = phoneNumberRepo.findAll();

        return numbers.stream()
                .map(this::mapPhoneNumberToDto)
                .collect(Collectors.toList());
    }
}
