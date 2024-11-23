package com.example.demo.repositories;

import com.example.demo.models.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository interface for managing `Terrain` entities.
 * Extends `CrudRepository` to provide basic CRUD operations for the `Terrain` entity.
 */
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
    /**
     * Decrements the quantite field of a Terrain by the specified value.
     *
     * @param id The ID of the terrain to update
     * @param decrementValue The value to decrement from the quantite
     */
    @Modifying
    @Transactional
    @Query("UPDATE Terrain t SET t.quantite = t.quantite - :decrementValue WHERE t.id = :id")
    void decrementQuantiteById(Integer id, Integer decrementValue);

    /**
     * Increments the quantite field of a Terrain by the specified value.
     *
     * @param id The ID of the terrain to update
     * @param incrementValue The value to increment to the quantite
     */
    @Modifying
    @Transactional
    @Query("UPDATE Terrain t SET t.quantite = t.quantite + :incrementValue WHERE t.id = :id")
    void incrementQuantiteById(Integer id, Integer incrementValue);
}
