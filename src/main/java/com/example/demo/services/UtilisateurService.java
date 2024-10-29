package com.example.demo.services;

import com.example.demo.models.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classes services -> conversions DTO
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Optional<Utilisateur> readUserById(Integer id){
        return utilisateurRepository.findById(id);
    }

    public Iterable<Utilisateur> readAllUser(){
        return utilisateurRepository.findAll();
    }

    public void deleteUserById(Integer id){
        utilisateurRepository.deleteById(id);
    }

    public void createUser(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public void updateUser(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }
}
