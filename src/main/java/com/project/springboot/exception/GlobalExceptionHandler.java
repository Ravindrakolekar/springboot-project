package com.project.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidHexException.class)
    public ResponseEntity<ErrorResponseRecord> handleInvalidHex(
            InvalidHexException ex) {

        ErrorResponseRecord response = new ErrorResponseRecord(
                OffsetDateTime.now(),
                400,
                "INVALID_HEX_VALUE",
                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponseRecord> handleNotFound(
            CustomerNotFoundException ex) {

        ErrorResponseRecord response = new ErrorResponseRecord(
                OffsetDateTime.now(),
                404,
                "CUSTOMER_NOT_FOUND",
                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
