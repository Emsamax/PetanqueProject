package com.example.demo.services;

import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.repositories.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

import java.util.Optional;
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
        // Vérifie si l'email ou l'id donné n'exisite pas déjà
        if (utilisateurRepository.findByMail(utilisateur.getMail()) != null) {
            throw new IllegalArgumentException("Given mail already exists");
        }

        if (utilisateur.getId() != null) {
            throw new IllegalArgumentException("Do not send user id");
        }

        // Sauvegarde un nouvel utilisateur ou un utilisateur mis à jour
        utilisateurRepository.save(utilisateurMapper.toEntity(utilisateur));
    }

    public void updateUtilisateur(Integer id, UtilisateurDTO utilisateur) throws ChangeSetPersister.NotFoundException, IllegalArgumentException {
        // Vérifie si l'utilisateur existe avant de procéder à la mise à jour
        if (!utilisateurRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }

        // Vérifie si l'email n'exsite pas déjà
        if (utilisateurRepository.findByMail(utilisateur.getMail()) != null) {
            throw new IllegalArgumentException();
        }

        // Supprime l'utilisateur existant puis sauvegarde le nouvel utilisateur
        utilisateur.setId(id);
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
