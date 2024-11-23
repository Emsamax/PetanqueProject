package com.example.demo.controllers;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.services.UtilisateurService;
import com.example.demo.utils.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller for managing user-related operations.
 * This controller provides endpoints to retrieve, create, update, and delete users.
 */
@RestController
@RequestMapping("/utilisateur")  // Base URL for all user-related endpoints
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;  // Service to handle user-related logic

    /**
     * Retrieve a user by ID.
     * Returns a user DTO if found, or a 404 response if not.
     *
     * @param id the ID of the user to retrieve
     * @return ResponseEntity containing the user DTO
     */
    @Operation(summary = "Get a user by ID", description = "Retrieve a user from the database using the given ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
            @ApiResponse(responseCode = "404", description = "User id not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Integer id) throws NotFoundException {
        UtilisateurDTO user = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.ok(user);  // Return the user data with a 200 OK response
    }

    /**
     * Retrieve all users.
     * Returns a list of all users as DTOs.
     *
     * @return Iterable collection of user DTOs
     */
    @Operation(summary = "Retrieve all users", description = "Get a list of all users in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public Iterable<UtilisateurDTO> getAllUtilisateur() {
        return utilisateurService.getAllUtilisateur();  // Retrieve and return all users
    }

    /**
     * Create a new user.
     * Accepts a user DTO in the request body and creates a new user in the database.
     *
     * @param userDTO the user data to be created
     * @return ResponseEntity with HTTP status 200 OK if successful
     */
    @Operation(summary = "Create a new user", description = "Create a new user by providing user details in the request body.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created user"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided in the body"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<Void> saveUtilisateur(@RequestBody UtilisateurDTO userDTO) throws IllegalArgumentException {
        utilisateurService.saveUtilisateur(userDTO);  // Save the user in the service layer
        return ResponseEntity.ok().build();  // Return 200 OK as the operation is successful
    }

    /**
     * Update an existing user by ID.
     * Accepts a user DTO and updates the user with the specified ID.
     *
     * @param userDTO the updated user data
     * @param id the ID of the user to update
     * @return ResponseEntity with HTTP status 200 OK if successful
     */
    @Operation(summary = "Update a user by ID", description = "Update an existing user by providing the new data and user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated user"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided in the body"),
            @ApiResponse(responseCode = "404", description = "User id not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtilisateur(@RequestBody UtilisateurDTO userDTO, @PathVariable Integer id) throws NotFoundException, IllegalArgumentException {
        utilisateurService.updateUtilisateur(id, userDTO);  // Update the user in the service layer
        return ResponseEntity.ok().build();  // Return 200 OK as the operation is successful
    }

    /**
     * Delete a user by ID.
     * Deletes the user with the specified ID from the database.
     *
     * @param id the ID of the user to delete
     * @return ResponseEntity with HTTP status 200 OK if successful
     */
    @Operation(summary = "Delete a user by ID", description = "Delete a user from the database using the given user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted user"),
            @ApiResponse(responseCode = "404", description = "User id not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) throws NotFoundException {
        utilisateurService.deleteUtilisateurById(id);  // Delete the user in the service layer
        return ResponseEntity.ok().build();  // Return 200 OK as the operation is successful
    }
}
