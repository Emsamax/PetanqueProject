package com.example.demo.controllers;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.services.UtilisateurService;

import com.example.demo.utils.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private UtilisateurService utilisateurService; // Service to handle user-related logic

    @Autowired
    private UtilisateurMapper utilisateurMapper; // Mapper to convert between DTOs and entities

    @Operation(summary = "", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Void> login(@RequestBody String mail, @RequestBody String password) throws NotFoundException {

        return ResponseEntity.ok().build();
    }
}
