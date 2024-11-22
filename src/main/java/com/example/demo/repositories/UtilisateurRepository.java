package com.example.demo.repositories;

import  com.example.demo.models.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
   Utilisateur findByMail(String mail);
}
