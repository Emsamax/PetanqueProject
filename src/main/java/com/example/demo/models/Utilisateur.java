package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * Représente un utilisateur dans le système.
 * Cette classe est mappée à la table "utilisateur" dans la base de données.
 * Les données de l'utilisateur comprennent le nom, l'email, le mot de passe et le nom d'utilisateur avec des règles de validation pour la sécurité.
 */
@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {

    /**
     * L'identifiant de l'utilisateur.
     * Généré automatiquement par la base de données et unique.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "L'identifiant unique de l'utilisateur.", example = "1")
    private Integer id;

    /**
     * Le nom de famille de l'utilisateur.
     * Ce champ ne peut pas être nul et doit contenir entre 1 et 100 caractères.
     */
    @Column(name = "nom", length = 100, nullable = false)
    @NotBlank(message = "Le nom ne peut pas être vide.")
    @Size(min = 1, max = 100, message = "Le nom doit comporter entre 1 et 100 caractères.")
    @Schema(description = "Le nom de l'utilisateur.", example = "Dupont")
    private String nom;

    /**
     * Le prénom de l'utilisateur.
     * Ce champ ne peut pas être nul et doit contenir entre 1 et 100 caractères.
     */
    @Column(name = "prenom", length = 100, nullable = false)
    @NotBlank(message = "Le prénom ne peut pas être vide.")
    @Size(min = 1, max = 100, message = "Le prénom doit comporter entre 1 et 100 caractères.")
    @Schema(description = "Le prénom de l'utilisateur.", example = "Jean")
    private String prenom;

    /**
     * L'adresse email de l'utilisateur.
     * Ce champ ne peut pas être nul, doit être un email valide et doit être unique.
     */
    @Column(name = "mail", length = 100, nullable = false, unique = true)
    @NotBlank(message = "L'email ne peut pas être vide.")
    @Email(message = "L'email doit être valide.")
    @Size(max = 100, message = "L'email ne peut pas dépasser 100 caractères.")
    @Schema(description = "L'email de l'utilisateur.", example = "jean.dupont@example.com")
    private String mail;

    /**
     * Le mot de passe de l'utilisateur.
     * Ce champ ne peut pas être nul et doit contenir entre 8 et 100 caractères.
     * Des mesures de sécurité doivent être mises en place sur le mot de passe (hachage).
     */
    @Column(name = "password", length = 100, nullable = false)
    @NotBlank(message = "Le mot de passe ne peut pas être vide.")
    @Size(min = 8, max = 100, message = "Le mot de passe doit comporter entre 8 et 100 caractères.")
    @Schema(description = "Le mot de passe de l'utilisateur (doit être sécurisé).", example = "MotDePasse123")
    private String password;

    /**
     * Le nom d'utilisateur de l'utilisateur.
     * Ce champ ne peut pas être nul, doit être unique et peut comporter jusqu'à 100 caractères.
     */
    @Column(name = "username", length = 100, nullable = false, unique = true)
    @NotNull(message = "Le nom d'utilisateur ne peut pas être nul.")
    @Size(min = 1, max = 100, message = "Le nom d'utilisateur doit comporter entre 1 et 100 caractères.")
    @Schema(description = "Le nom d'utilisateur unique de l'utilisateur.", example = "jdupont")
    private String username;

    /**
     * Une liste de réservations associées à l'utilisateur.
     * Ce champ est optionnel et contient toutes les réservations liées à cet utilisateur.
     */
    @OneToMany(mappedBy = "utilisateur")
    @Schema(description = "La liste des réservations associées à l'utilisateur.",
            implementation = Reservation.class)
    private List<Reservation> reservations;
}
