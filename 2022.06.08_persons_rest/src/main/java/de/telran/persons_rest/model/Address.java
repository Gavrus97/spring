package de.telran.persons_rest.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Integer id;
    private String address;
    private String city;
    private String zip;
    private String country;

    @ManyToOne
    private Person person;

    public Address(Integer id, String address, String city, String zip, String country, Person person) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.person = person;
    }

    public Address() {

    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public Person getPerson() {
        return person;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
