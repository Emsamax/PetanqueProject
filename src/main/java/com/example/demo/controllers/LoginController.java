package com.example.demo.controllers;

import com.example.demo.services.UtilisateurService;
import com.example.demo.utils.NotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

/**
 * Controller for handling login operations.
 * Exposes endpoints to authenticate users by email and password.
 */
@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private UtilisateurService utilisateurService; // Service to handle user-related logic

    /**
     * Endpoint for user login.
     *
     * @param mail     The email of the user attempting to log in
     * @param password The password of the user
     * @return ResponseEntity with HTTP status 200 if login is successful
     * @throws NotFoundException if the user is not found or if the password is incorrect
     */
    @Operation(summary = "User login", description = "Authenticate a user by email and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "404", description = "User not found or incorrect password"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{mail}/{password}")
    public ResponseEntity<Void> login(@PathVariable String mail, @PathVariable String password) throws NotFoundException {
        utilisateurService.login(mail, password);
        return ResponseEntity.ok().build();
    }
}
