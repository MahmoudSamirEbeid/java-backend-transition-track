package com.bm.rest_web_services.Exception;

import com.bm.rest_web_services.DTO.ErrorDetails;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    private MessageSource messageSource;

    public CustomizedResponseEntityExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        Locale locale = LocaleContextHolder.getLocale();

        Map<String, String> arguments = (Map<String, String> )request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

        String message = messageSource.getMessage(
                "user.not.found",
                new Object[]{arguments.get("id")},
                "",
                locale
        );

        ErrorDetails errorDetails = new ErrorDetails(message, LocalDateTime.now(), request.getDescription(false), null);
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
