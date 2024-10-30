package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object for Utilisateur.
 */
@Data
public class UtilisateurDTO {

    /**
     * The identifier for the user.
     * Typically excluded from requests when creating a new user.
     */
    private Integer id;

    /**
     * The last name of the user (100 characters max).
     * Cannot be null or blank.
     */
    @NotBlank
    private String nom;

    /**
     * The first name of the user (100 characters max).
     * Cannot be null or blank.
     */
    @NotBlank
    private String prenom;

    /**
     * The email address of the user (100 characters max).
     * Cannot be null, blank, and must be a valid email format.
     */
    @NotNull
    @Email
    private String mail;

    /**
     * The password of the user (100 characters max).
     * Cannot be null or blank.
     */
    @NotBlank
    private String password;

    /**
     * The username of the user (100 characters max).
     * Cannot be null, blank, and must be unique.
     */
    @NotBlank
    private String username;
}
