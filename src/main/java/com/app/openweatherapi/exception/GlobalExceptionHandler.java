package com.app.openweatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> badArgumentsException(MethodArgumentNotValidException exception, WebRequest request) {

        return new ResponseEntity<>(new ErrorDetails(

                exception.getLocalizedMessage(),
                HttpStatus.BAD_REQUEST.toString(),
                new Date(), request.getDescription(false)), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(WeatherFormatExtension.class)
    public ResponseEntity<ErrorDetails> badOrderIdException(WeatherFormatExtension exception, WebRequest request) {

        return new ResponseEntity<>(new ErrorDetails(

                exception.getLocalizedMessage(),
                HttpStatus.NOT_FOUND.toString(),
                new Date(), request.getDescription(false)), HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> badOrderIdException(Exception exception, WebRequest request) {

        return new ResponseEntity<>(new ErrorDetails(

                exception.getLocalizedMessage(),
                HttpStatus.NOT_FOUND.toString(),
                new Date(), request.getDescription(false)), HttpStatus.BAD_REQUEST);


    }

}
