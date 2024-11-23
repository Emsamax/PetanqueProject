package com.example.demo.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler that intercepts specific exceptions across all controllers in the application.
 * It provides custom error responses based on the exception type.
 */
@ControllerAdvice
public class RESTResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle exceptions IllegalArgumentException and NotFoundException.
     * This method generates custom error responses based on the exception type. It responds with a
     * corresponding HTTP status and a message explaining the error in detail.
     *
     * @param exception the exception that was thrown during the request processing
     * @param request the web request that triggered the exception
     * @return a ResponseEntity containing the error details and corresponding HTTP status
     */
    @ExceptionHandler(value = {IllegalArgumentException.class, NotFoundException.class})
    protected ResponseEntity<Object> handleConflict(Exception exception, WebRequest request) {
        // Create an ErrorResponse object to encapsulate the error details
        ErrorResponse errorResponse = new ErrorResponse();

        // Handling IllegalArgumentException: Indicates a bad request due to invalid input
        if (exception instanceof IllegalArgumentException)
        {
            errorResponse.setError("Bad Request");
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            errorResponse.setMessage(String.format("Parameter error: %s.", exception.getMessage()));

            // Return a ResponseEntity with 400 Bad Request status and the error response details
            return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }
        else if (exception instanceof NotFoundException)
        {
            errorResponse.setError("Not Found");
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setMessage(String.format("Parameter error: %s.", exception.getMessage()));
            return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
        }

        // Handling any other unexpected exceptions: This is a catch-all for unforeseen errors (500 Internal Server Error)
        errorResponse.setError("Internal Server Error");
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("An unexpected error occurred. Please try again later.");

        // Return a ResponseEntity with 500 Internal Server Error status and the error response details
        return handleExceptionInternal(exception, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
