package com.example.demo.services;

import com.example.demo.models.Terrain;
import com.example.demo.dto.TerrainDTO;
import com.example.demo.mappers.TerrainMapper;
import com.example.demo.repositories.TerrainRepository;
import com.example.demo.utils.NotFoundException;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Terrain entities.
 * This class contains the business logic for handling terrain operations
 */
@Service
@NoArgsConstructor
public class TerrainService {

    @Autowired
    private TerrainRepository terrainRepository;  // Repository for accessing terrain data in the database

    @Autowired
    private TerrainMapper terrainMapper;  // Mapper for converting between Terrain entities and DTOs

    /**
     * Retrieves a terrain by its ID.
     * If the terrain is not found, a NotFoundException is thrown.
     *
     * @param id the ID of the terrain to retrieve
     * @return the TerrainDTO representing the terrain
     * @throws NotFoundException if the terrain with the specified ID is not found
     */
    public TerrainDTO getTerrainById(Integer id) throws NotFoundException {
        // Attempt to find the terrain by its ID. If not found, throw a NotFoundException
        return terrainRepository.findById(id)
                .map(terrainMapper::toDTO)  // Map the entity to a DTO
                .orElseThrow(() -> new NotFoundException("Terrain with ID " + id + " not found"));  // Exception if not found
    }

    /**
     * Retrieves all terrains from the database.
     *
     * @return an iterable collection of TerrainDTOs representing all terrains
     */
    public Iterable<TerrainDTO> getAllTerrain() {
        // Retrieve all terrains and convert them to DTOs
        return terrainRepository.findAll().stream()
                .map(terrainMapper::toDTO)  // Map each Terrain entity to a TerrainDTO
                .toList();  // Return as a list
    }

    /**
     * Saves a terrain (either creating or updating it).
     *
     * @param terrain the TerrainDTO to save (either create or update)
     */
    public void saveTerrain(TerrainDTO terrain) {
        // Save the terrain, converting the DTO to an entity before saving
        terrainRepository.save(terrainMapper.toEntity(terrain));
    }

    /**
     * Updates an existing terrain by its ID.
     * If the terrain is not found, a NotFoundException is thrown.
     *
     * @param id the ID of the terrain to update
     * @param terrain the updated TerrainDTO
     * @throws NotFoundException if the terrain with the specified ID does not exist
     */
    public void updateTerrain(Integer id, TerrainDTO terrain) throws NotFoundException {
        // Check if the terrain with the specified ID exists before updating
        if (!terrainRepository.existsById(id)) {
            throw new NotFoundException("Terrain with ID " + id + " not found");  // Exception if not found
        }

        // Save the updated terrain entity
        terrainRepository.save(terrainMapper.toEntity(terrain));
    }

    /**
     * Deletes a terrain by its ID.
     * If the terrain is not found, a NotFoundException is thrown.
     *
     * @param id the ID of the terrain to delete
     * @throws NotFoundException if the terrain with the specified ID does not exist
     */
    public void deleteTerrainById(Integer id) throws NotFoundException {
        // Check if the terrain exists before attempting to delete
        if (!terrainRepository.existsById(id)) {
            throw new NotFoundException("Terrain with ID " + id + " not found");  // Exception if not found
        }

        // Delete the terrain from the database
        terrainRepository.deleteById(id);
    }

    /**
     * Decrements the quantity of a terrain by a specified value.
     * This method updates the quantity of terrain available by decreasing it based on the provided
     * decrement value. It also ensures that the quantity does not fall below zero.
     *
     * @param id the ID of the terrain whose quantity is to be decremented
     * @param decrementValue the value by which the quantity should be reduced
     * @throws NotFoundException if the terrain with the given ID is not found
     * @throws IllegalArgumentException if the decrement value is greater than the current available quantity
     */
    public void decrementQuantite(Integer id, Integer decrementValue) throws NotFoundException, IllegalArgumentException {
        // Retrieve the terrain entity by its ID, throwing a NotFoundException if not found
        Terrain terrain = terrainRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Terrain with ID " + id + " not found"));

        // Get the current quantity of the terrain
        Integer terrainQuantity = terrain.getQuantite();

        // Ensure that the requested decrement does not exceed the available quantity
        if (terrainQuantity < decrementValue) {
            // If not enough quantity is available, throw an IllegalArgumentException
            throw new IllegalArgumentException("You can't reserve " + decrementValue +  " number of terrains, as only " + terrainQuantity  + " plots are available");
        }

        // If the decrement is valid, update the terrain's quantity
        terrainRepository.decrementQuantiteById(id, decrementValue);
    }

    /**
     * Increments the quantity of a terrain by a specified value.
     * This method updates the quantity of terrain available by increasing it based on the provided
     * increment value.
     *
     * @param id the ID of the terrain whose quantity is to be incremented
     * @param incrementValue the value by which the quantity should be increased
     * @throws NotFoundException if the terrain with the given ID is not found
     */
    public void incrementQuantite(Integer id, Integer incrementValue) throws NotFoundException {
        // Retrieve the terrain entity by its ID, throwing a NotFoundException if not found
        Terrain terrain = terrainRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Terrain with ID " + id + " not found"));

        // Ensure the increment value is positive
        if (incrementValue < 0) {
            throw new IllegalArgumentException("You cannot increment terrain quantity with negative value. Use decremental method instead");
        }

        // If the increment is valid, update the terrain's quantity
        terrainRepository.incrementQuantiteById(id, incrementValue);
    }

}
