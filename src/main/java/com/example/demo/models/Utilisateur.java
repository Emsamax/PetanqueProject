package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull; // use javax.validation.constraints.NotNull

/*
 * TO DO :
 * - Add security for password and mail
 */

/**
 * Represents a user in the system.
 * This class is mapped to the "utilisateur" table in the database.
 */
@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
    /**
     * The identifier for the user.
     * Is unique.
     * Automatically generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The last name of the user (100 characters max).
     * Cannot be null.
     */
    @Column(name="nom", length=100, nullable=false)
    @NotNull
    private String nom;

    /**
     * The first name of the user (100 characters max).
     * Cannot be null.
     */
    @Column(name="prenom", length=100, nullable=false)
    @NotNull
    private String prenom;

    /**
     * The email address of the user (100 characters max).
     * Cannot be null.
     * Is unique.
     */
    @Column(name="mail", length=100, nullable=false, unique=true)
    @NotNull
    private String mail;

    /**
     * The password of the user (100 characters max).
     * Cannot be null.
     */
    @Column(name="password", length=100, nullable=false)
    @NotNull
    private String password;

    /**
     * The username of the user (100 characters max).
     * Cannot be null.
     * Is unique.
     */
    @Column(name="username", length=100, nullable=false, unique=true)
    @NotNull
    private String username;
}
