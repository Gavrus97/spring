package de.telran.spring_mvc_demo.webmodel;

public class PeopleForm {

    private String firstName;
    private String lastName;

    public PeopleForm (){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
