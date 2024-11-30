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

    @Operation(summary = "", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{mail}/{password}")
    public ResponseEntity<Void> login(@PathVariable String mail, @PathVariable String password) throws NotFoundException {
        utilisateurService.login(mail, password);
        return ResponseEntity.ok().build();
    }

}
