package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * Represents a user in the system.
 * This class is mapped to the "utilisateur" table in the database.
 * User data includes name, email, password, and username with validation rules for security.
 */
@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * The user's identifier.
     * Automatically generated by the database and unique.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier of the user.")
    private Integer id;

    /**
     * The user's last name.
     * This field cannot be null and must contain between 1 and 100 characters.
     */
    @Column(name = "nom", length = 100, nullable = false)
    @NotBlank(message = "The last name cannot be empty.")
    @Size(min = 1, max = 100, message = "The last name must be between 1 and 100 characters.")
    @Schema(description = "The user's last name.")
    private String nom;

    /**
     * The user's first name.
     * This field cannot be null and must contain between 1 and 100 characters.
     */
    @Column(name = "prenom", length = 100, nullable = false)
    @NotBlank(message = "The first name cannot be empty.")
    @Size(min = 1, max = 100, message = "The first name must be between 1 and 100 characters.")
    @Schema(description = "The user's first name.")
    private String prenom;

    /**
     * The user's email address.
     * This field cannot be null, must be a valid email, and must be unique.
     */
    @Column(name = "mail", length = 100, nullable = false, unique = true)
    @NotBlank(message = "The email cannot be empty.")
    @Email(message = "The email must be valid.")
    @Size(max = 100, message = "The email cannot exceed 100 characters.")
    @Schema(description = "The user's email.")
    private String mail;

    /**
     * The user's password.
     * This field cannot be null and must contain between 8 and 100 characters.
     * Security measures must be implemented for the password (e.g., hashing).
     */
    @Column(name = "password", length = 100, nullable = false)
    @NotBlank(message = "The password cannot be empty.")
    @Size(min = 8, max = 100, message = "The password must be between 8 and 100 characters.")
    @Schema(description = "The user's password.")
    private String password;

    /**
     * The user's username.
     * This field cannot be null, must be unique, and can contain up to 100 characters.
     */
    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(message = "The username cannot be null.")
    @Size(min = 1, max = 100, message = "The username must be between 1 and 100 characters.")
    @Schema(description = "The username of the user.")
    private String username;

    /**
     * A list of reservations associated with the user.
     * This field is optional and contains all reservations linked to this user.
     */
    @OneToMany(mappedBy = "utilisateur")
    @Schema(description = "The list of reservations associated with the user.",
            implementation = Reservation.class)
    private List<Reservation> reservations;
}
