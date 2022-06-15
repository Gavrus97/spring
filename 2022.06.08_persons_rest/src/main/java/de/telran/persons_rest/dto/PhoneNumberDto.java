package de.telran.persons_rest.dto;

public class PhoneNumberDto {

    public Integer id;
    public String number;
    public String countryCode;
    public int personId;

    public PhoneNumberDto(Integer id, String number, String countryCode, int personId) {
        this.id = id;
        this.number = number;
        this.countryCode = countryCode;
        this.personId = personId;
    }

    public PhoneNumberDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getPersonId() {
        return personId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
