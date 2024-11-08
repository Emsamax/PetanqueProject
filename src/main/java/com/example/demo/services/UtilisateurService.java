package com.example.demo.services;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.repositories.UtilisateurRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Classes services -> conversions DTO
 */
@Service
@NoArgsConstructor
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
              .map(utilisateurMapper::toDTO).toList();
    }

    public void deleteUserById(Integer id){
        utilisateurRepository.deleteById(id);
    }

    public void saveUser(UtilisateurDTO utilisateur){
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }

    public void updateUser(UtilisateurDTO utilisateur){
        deleteUserById(utilisateur.getId());
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }
}
