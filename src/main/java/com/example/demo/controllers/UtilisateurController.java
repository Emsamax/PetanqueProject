package com.example.demo.controllers;

import com.example.demo.UtilisateurMapper;
import com.example.demo.models.Utilisateur;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable Integer id) {
        Optional<UtilisateurDTO> optUser = utilisateurService.readUserById(id);
        if(optUser.isPresent()) {
            return ResponseEntity.ok(optUser.get());
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/utilisateur")
    public void saveUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        utilisateurService.saveUser(utilisateurDTO);
        ResponseEntity.ok().build();
    }

    @GetMapping("/utilisateurs")
    public ResponseEntity<Iterable<UtilisateurDTO>> getAllUtilisateurs() {
        System.out.println("ici");
        Iterable<UtilisateurDTO> optUsers = utilisateurService.readAllUser();
        if(optUsers != null) {
            return ResponseEntity.ok(optUsers);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/utilisateur/{id}")
    public ResponseEntity<Void> updateUtilisateur(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
        if(utilisateurService.readUserById(id).isPresent()) {
            utilisateurService.updateUser(utilisateurMapper.toDTO(utilisateur));
            return ResponseEntity.ok().build();
        }else {
           return ResponseEntity.badRequest().build();
        }
    }
}
