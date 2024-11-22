package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for the Utilisateur entity.
 * This class is used to transfer user data between layers (e.g., between controllers and services).
 * It includes user details such as name, email, password, and username.
 */
@Data
public class UtilisateurDTO {

    /**
     * The identifier for the user.
     * Typically excluded from requests when creating a new user.
     * The ID is auto-generated in the database.
     */
    @Schema(description = "The unique identifier of the user (auto-generated). Typically excluded in creation requests.")
    private Integer id;

    /**
     * The last name of the user.
     * This field cannot be null or blank and has a maximum length of 100 characters.
     */
    @NotBlank(message = "The last name cannot be empty.")
    @Schema(description = "The last name of the user (cannot be null or blank, max 100 characters).")
    private String nom;

    /**
     * The first name of the user.
     * This field cannot be null or blank and has a maximum length of 100 characters.
     */
    @NotBlank(message = "The first name cannot be empty.")
    @Schema(description = "The first name of the user (cannot be null or blank, max 100 characters).")
    private String prenom;

    /**
     * The email address of the user.
     * This field cannot be null, cannot be blank, and must be a valid email format.
     * The email has a maximum length of 100 characters.
     */
    @NotNull(message = "The email cannot be null.")
    @Email(message = "The email must be valid.")
    @Schema(description = "The email address of the user (cannot be null, must be valid, max 100 characters).")
    private String mail;

    /**
     * The password of the user.
     * This field cannot be null or blank and should have a minimum length for security.
     * The password has a maximum length of 100 characters.
     */
    @NotBlank(message = "The password cannot be empty.")
    @Schema(description = "The password of the user (cannot be null or blank, max 100 characters).")
    private String password;

    /**
     * The username of the user.
     * This field cannot be null, cannot be blank, and must be unique within the system.
     * The username has a maximum length of 100 characters.
     */
    @NotBlank(message = "The username cannot be empty.")
    @Schema(description = "The username of the user (cannot be null, must be unique, max 100 characters).")
    private String username;
}
