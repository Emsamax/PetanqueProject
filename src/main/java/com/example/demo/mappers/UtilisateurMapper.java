package com.example.demo.mappers;

import com.example.demo.models.Utilisateur;
import com.example.demo.dto.UtilisateurDTO;

import org.mapstruct.Mapper;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Mapper interface for converting between the Utilisateur entity and its corresponding DTO (UtilisateurDTO).
 * This interface uses MapStruct to automate the mapping process between the entity and DTO.
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    /**
     * Converts a Utilisateur entity to its corresponding UtilisateurDTO.
     *
     * @param utilisateur the Utilisateur entity to be converted
     * @return the corresponding UtilisateurDTO
     */
    @Schema(description = "Converts a Utilisateur entity to its corresponding UtilisateurDTO.")
    UtilisateurDTO toDTO(Utilisateur utilisateur);

    /**
     * Converts a UtilisateurDTO to its corresponding Utilisateur entity.
     *
     * @param utilisateurDTO the UtilisateurDTO to be converted
     * @return the corresponding Utilisateur entity
     */
    @Schema(description = "Converts a UtilisateurDTO to its corresponding Utilisateur entity.")
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}
