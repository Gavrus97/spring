package de.telran.apartmentproject.error_handler;

import de.telran.apartmentproject.dto.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ErrorResponseDTO handleError(ResponseStatusException ex){
        return ErrorResponseDTO.builder()
                .message(ex.getReason())
                .status(ex.getStatus())
                .build();

    }
}
