package de.telran.planepassengers.dto;

import de.telran.planepassengers.entity.type.TicketType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PassengerFlightDTO {


    @NotBlank
    private String name;

    @Email(message = "Email form is incorrect")
    @NotBlank(message = "Email cannot be blank")
    @Length(min = 5, max = 50, message = "Email length should be between 5 and 50 chars")
    private String email;

    @NotNull
    private TicketType ticketType;
}
