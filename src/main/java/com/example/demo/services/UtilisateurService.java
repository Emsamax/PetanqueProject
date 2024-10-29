package com.example.demo.services;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mapper.UtilisateurMapper;
import com.example.demo.models.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Classes services -> conversions DTO
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public Optional<UtilisateurDTO> readUserById(Integer id){
        return utilisateurRepository.findById(id).map(utilisateurMapper::toDTO);
    }

    public Iterable<UtilisateurDTO> readAllUser(){
      return StreamSupport.stream(utilisateurRepository.findAll().spliterator(), false)
              .map(utilisateurMapper::toDTO)
              .collect(Collectors.toList());
    }

    public void deleteUserById(Integer id){
        utilisateurRepository.deleteById(id);
    }

    public void createUser(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public void updateUser(UtilisateurDTO utilisateur){
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }
}
