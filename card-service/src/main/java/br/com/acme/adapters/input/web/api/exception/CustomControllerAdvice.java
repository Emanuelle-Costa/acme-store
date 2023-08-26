package br.com.acme.adapters.input.web.api.exception;

import br.com.acme.application.domain.exception.ApiErrorsResponse;
import br.com.acme.application.domain.exception.CardNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ApiErrorsResponse> handleCardNotFoundException(
            CardNotFoundException exception, WebRequest webRequest
    ){
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("Card not found")
                .dateTime(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message("Card search not found")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .dataMessageError(dataError)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.NOT_FOUND);
    }
}
