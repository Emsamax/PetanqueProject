package com.example.demo.repositories;

import com.example.demo.models.Utilisateur;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing `Utilisateur` entities.
 * Extends `CrudRepository` to provide basic CRUD operations for the `Utilisateur` entity.
 */
@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {

   /**
    * Finds a `Utilisateur` by its email address.
    * This method will automatically generate the necessary SQL query to find a user based on the email field.
    *
    * @param mail the email address to search for
    * @return the `Utilisateur` entity associated with the provided email address, or `null` if no user is found
    */
   Optional<Utilisateur> findByMail(String mail);
}
