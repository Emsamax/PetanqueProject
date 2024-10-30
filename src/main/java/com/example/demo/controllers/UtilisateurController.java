package com.example.demo.controllers;

import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.models.Utilisateur;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    // Create a new user
    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        utilisateurService.saveUser(utilisateurDTO);
        return ResponseEntity.ok().build();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable Integer id) {
        Optional<UtilisateurDTO> optUser = utilisateurService.readUserById(id);
        return optUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all users
    @GetMapping
    public ResponseEntity<Iterable<UtilisateurDTO>> getAllUtilisateurs() {
        Iterable<UtilisateurDTO> optUsers = utilisateurService.readAllUser();
        if (optUsers != null) {
            return ResponseEntity.ok(optUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        if (utilisateurService.readUserById(id).isPresent()) {
            utilisateurService.deleteUserById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO, @PathVariable Integer id) {
        if (utilisateurService.readUserById(id).isPresent()) {
            utilisateurService.updateUser(utilisateurDTO);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
