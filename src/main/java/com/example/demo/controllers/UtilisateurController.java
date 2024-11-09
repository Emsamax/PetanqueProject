package com.example.demo.controllers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.models.Utilisateur;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Integer id) throws Exception {
        Optional<UtilisateurDTO> utilisateurDTO = utilisateurService.getUtilisateurById(id);
        UtilisateurDTO user = utilisateurDTO.get();
        return ResponseEntity.ok(user);
    }

    /**
     * Retrieve all terrains.
     */
    @GetMapping
    public Iterable<UtilisateurDTO> getAllUtilisateur() throws Exception {
        return utilisateurService.getAllUtilisateur();
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<Void> saveUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        utilisateurService.saveUtilisateur(utilisateurDTO);
        return ResponseEntity.ok().build();
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO, @PathVariable Integer id) throws Exception {
        return ResponseEntity.notFound().build();
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) throws Exception {
        return ResponseEntity.notFound().build();
    }
}
