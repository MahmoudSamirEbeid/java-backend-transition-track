package com.bm.rest_web_services.Exception;

import com.bm.rest_web_services.DTO.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), request.getDescription(false), null);
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<String> errorList = ex.getFieldErrors().stream().map(
                error -> error.getField() +
                        " ( " +
                        error.getRejectedValue().toString() +
                        " ) " +
                        error.getDefaultMessage()
        ).toList();

//        String message = ex.getFieldError().getField() +
//                " ( " +
//                ex.getFieldError().getRejectedValue().toString() +
//                " ) " +
//                ex.getFieldError().getDefaultMessage();

        String message = "Validation Failed";

        ErrorDetails errorDetails = new ErrorDetails(
                message,
                LocalDateTime.now(),
                request.getDescription(false),
                errorList
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
