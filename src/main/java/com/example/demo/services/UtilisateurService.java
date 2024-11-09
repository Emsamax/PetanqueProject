package com.example.demo.services;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.repositories.UtilisateurRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Classe de services -> conversions DTO
 */
@Service
@NoArgsConstructor
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    public Optional<UtilisateurDTO> getUtilisateurById(Integer id) throws ChangeSetPersister.NotFoundException {
        // Si l'utilisateur n'est pas trouvé, une exception NotFound est lancée
        return Optional.ofNullable(utilisateurRepository.findById(id)
                .map(utilisateurMapper::toDTO)
                .orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public Iterable<UtilisateurDTO> getAllUtilisateur() {
        // Récupère tous les utilisateurs et les convertit en DTO
        return StreamSupport.stream(utilisateurRepository.findAll().spliterator(), false)
                .map(utilisateurMapper::toDTO).toList();
    }

    public void saveUtilisateur(UtilisateurDTO utilisateur) {
        // Sauvegarde un nouvel utilisateur ou un utilisateur mis à jour
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }

    public void updateUtilisateur(UtilisateurDTO utilisateur) throws ChangeSetPersister.NotFoundException {
        // Vérifie si l'utilisateur existe avant de procéder à la mise à jour
        if (!utilisateurRepository.existsById(utilisateur.getId())) {
            throw new ChangeSetPersister.NotFoundException();
        }
        // Supprime l'utilisateur existant puis sauvegarde le nouvel utilisateur
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }

    public void deleteUtilisateurById(Integer id) throws ChangeSetPersister.NotFoundException {
        // Vérifie si l'utilisateur existe avant de le supprimer
        if (!utilisateurRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        utilisateurRepository.deleteById(id);
    }
}
