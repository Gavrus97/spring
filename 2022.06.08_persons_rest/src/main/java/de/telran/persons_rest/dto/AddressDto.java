package de.telran.persons_rest.dto;

public class AddressDto {

    public Integer id;
    public String address;
    public String city;
    public String zip;
    public String country;

    public int personId;

    public AddressDto(){

    }

    public AddressDto(Integer id, String address, String city, String zip, String country, int personId) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPersonId() {
        return personId;
    }
}
