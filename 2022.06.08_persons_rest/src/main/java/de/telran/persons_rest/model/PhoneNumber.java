package de.telran.persons_rest.model;

import javax.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Integer id;
    private String countryCode;
    private String  number;

    @ManyToOne
    private Person person;

    public PhoneNumber(Integer id, String countryCode, String number, Person person) {
        this.id = id;
        this.countryCode = countryCode;
        this.number = number;
        this.person = person;
    }

    public PhoneNumber() {
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }
}
