package com.example.demo.services;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.models.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import com.example.demo.utils.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

import java.util.stream.StreamSupport;

/**
 * User service class.
 * This class is responsible for handling business logic related to users, such as retrieving,
 * creating, updating, and deleting user data.
 */
@Service
@NoArgsConstructor
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository; // Repository for database access

    @Autowired
    private UtilisateurMapper utilisateurMapper; // Mapper to convert between DTOs and entities

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Retrieve a user by ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user DTO if found
     * @throws NotFoundException if the user with the given ID is not found
     */
    public UtilisateurDTO getUtilisateurById(Integer id) throws NotFoundException {
        return utilisateurRepository.findById(id)  // Attempt to find the user by ID
                .map(utilisateurMapper::toDTO)  // Convert to DTO if found
                .orElseThrow(() -> new NotFoundException("User with ID " + id + " not found"));
    }

    /**
     * Retrieve all users.
     * Converts each user entity found in the repository into a DTO.
     *
     * @return a collection of user DTOs
     */
    public Iterable<UtilisateurDTO> getAllUtilisateur() {
        return StreamSupport.stream(utilisateurRepository.findAll().spliterator(), false)  // Convert entities to DTOs
                .map(utilisateurMapper::toDTO)  // Map each entity to a DTO
                .toList();
    }

    /**
     * Save a new user or update an existing user.
     *
     * @param user the user DTO to save
     * @throws IllegalArgumentException if the email already exists
     */
    public void saveUtilisateur(UtilisateurDTO user) throws IllegalArgumentException {
        String userMail = user.getMail();

        // Check if a user with the same email already exists
        if (utilisateurRepository.findByMail(userMail) != null) {
            throw new IllegalArgumentException("User with mail " + userMail + " already exists");
        }

        // Save or update the user in the database
        utilisateurRepository.save(utilisateurMapper.toEntity(user));
    }

    /**
     * Update an existing user.
     *
     * @param id the ID of the user to update
     * @param user the updated user DTO
     * @throws IllegalArgumentException if the email already exists or if the user does not exist
     * @throws NotFoundException if the user with the given ID is not found
     */
    public void updateUtilisateur(Integer id, UtilisateurDTO user) throws NotFoundException, IllegalArgumentException {
        String userNewMail = user.getMail();

        // Check if the user exists
        if (!utilisateurRepository.existsById(id)) {
            throw new NotFoundException("User with id " + id + " not found");
        }

        // Check if a user with the same email already exists
        if (utilisateurRepository.findByMail(userNewMail).isPresent()) {
            throw new IllegalArgumentException("User with mail " + userNewMail + " already exists");
        }

        // Update the user and save in the database
        user.setId(id);  // Set the ID to ensure the existing entity is updated
        utilisateurRepository.save(utilisateurMapper.toEntity(user));
    }

    /**
     * Delete a user by ID.
     *
     * @param id the ID of the user to delete
     * @throws NotFoundException if the user with the given ID is not found
     */
    public void deleteUtilisateurById(Integer id) throws NotFoundException {
        // Check if the user exists before attempting to delete
        if (!utilisateurRepository.existsById(id)) {
            throw new NotFoundException("User with id " + id + " not found");
        }

        // Delete the user from the database
        utilisateurRepository.deleteById(id);
    }

    public Boolean login(String mail, String password) throws NotFoundException {
        // Get the user
        Utilisateur utilisateur = utilisateurRepository.findByMail(mail)
                .orElseThrow(() -> new NotFoundException("User with mail " + mail + " not found"));

        // If the password doesn't correspond, throw exception
        if (!utilisateur.getPassword().equals(password)) {
            throw new NotFoundException("Wrong password");
        }

        return true;
    }
}
