package com.example.demo.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the error response structure for the API.
 * This class is used to format the error response returned to the client in case of failure.
 * The response includes details about the error such as timestamp, status, error message, and additional details.
 */
@Data
@NoArgsConstructor
public class ErrorResponse {

    /**
     * The timestamp of the error occurrence.
     * The time when the error was generated, typically in milliseconds since the Unix epoch.
     */
    @Schema(description = "The timestamp of when the error occurred.")
    private long timestamp;

    /**
     * The HTTP status code associated with the error.
     * Represents the status code of the response, such as 400 for bad requests, 404 for not found, etc.
     */
    @Schema(description = "The HTTP status code associated with the error.")
    private int status;

    /**
     * A brief description of the error.
     * A short error message or code representing the type of error (e.g., 'Bad Request', 'Not Found').
     */
    @Schema(description = "The short description of the error.")
    private String error;

    /**
     * A detailed error message.
     * Provides additional information regarding the cause of the error, typically used for debugging or providing more context.
     */
    @Schema(description = "A detailed error message that provides more context about the error.")
    private String message;
}
