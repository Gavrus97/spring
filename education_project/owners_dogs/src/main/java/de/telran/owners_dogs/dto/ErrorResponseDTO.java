package de.telran.owners_dogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Builder
@Data
public class ErrorResponseDTO {

    private HttpStatus status;
    private String message;
}
