package com.example.demo.repository;

import  com.example.demo.models.Utilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
}
