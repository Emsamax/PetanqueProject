package com.example.demo.utils;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RESTResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, ChangeSetPersister.NotFoundException.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();

        if (ex instanceof IllegalArgumentException)
        {
            errorResponse.setError("Bad Request");
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            errorResponse.setMessage(String.format("Erreur de paramètres : %s. Les paramètres fournis ne correspondent pas aux attentes pour cette requête.", ex.getMessage()));
            return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }
        else if (ex instanceof ChangeSetPersister.NotFoundException)
        {
            errorResponse.setError("Not Found");
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage("L'objet demandé avec l'ID fourni n'a pas été trouvé dans la base de données. Veuillez vérifier l'ID et réessayer.");
            return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }

        errorResponse.setError("Internal Server Error");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("Une erreur inattendue s'est produite. Veuillez réessayer plus tard.");
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
