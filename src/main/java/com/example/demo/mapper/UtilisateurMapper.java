package com.example.demo.mapper;

import com.example.demo.models.Utilisateur;
import com.example.demo.dto.UtilisateurDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO toDTO(Utilisateur utilisateur);

    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);

}
