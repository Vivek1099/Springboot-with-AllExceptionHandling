package Springboot_AllException_example.Handler;


import Springboot_AllException_example.Exceptions.AccountNotFoundException;
import Springboot_AllException_example.Exceptions.IdNotFoundException;
import Springboot_AllException_example.Exceptions.NameNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();
        // Parse the exception message or use ConstraintViolation to get detailed information
        exception.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        String errorMessage = "Database error occurred.";

        // Checking the exact field names in the exception message
        if (exception.getMessage().contains("(phone)")) {
            errorMessage = "Phone number already exists.";
        } else if (exception.getMessage().contains("(account)")) {
            errorMessage = "Account number already exists.";
        }


        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(IdNotFoundException exception)
    {
        ResponseEntity<Object> entity = new ResponseEntity<>("Id Not Found...!!", HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Object> handleException(NameNotFoundException exception)
    {
        ResponseEntity<Object> entity = new ResponseEntity<>("Name Not Found...!!", HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> handleException(AccountNotFoundException exception)
    {
        ResponseEntity<Object> entity = new ResponseEntity<>("Account Not Found.....!!", HttpStatus.NOT_FOUND);
        return entity;
    }
}
