package com.example.demo.controllers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.services.TerrainService;
import com.example.demo.utils.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller class for handling Terrain-related HTTP requests.
 * Provides endpoints for performing CRUD operations on terrain resources.
 */
@RestController
@RequestMapping("/terrain")  // Maps all requests starting with /terrain to this controller
public class TerrainController {

    @Autowired
    private TerrainService terrainService;  // Service layer for managing terrain operations

    /**
     * Retrieve a terrain by its ID.
     * This method delegates the request to the terrainService and returns the terrain as a DTO.
     * If the terrain is not found, a NotFoundException will be thrown.
     *
     * @param id the ID of the terrain to retrieve
     * @return ResponseEntity containing the terrain DTO and a 200 OK status
     * @throws NotFoundException if the terrain with the specified ID is not found
     */
    @Operation(summary = "Get a terrain by ID", description = "Retrieve a terrain by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved terrain"),
            @ApiResponse(responseCode = "404", description = "Terrain ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")  // Maps GET requests to /terrain/{id}
    public ResponseEntity<TerrainDTO> getTerrainById(@PathVariable Integer id) throws NotFoundException {
        TerrainDTO terrain = terrainService.getTerrainById(id);
        return ResponseEntity.ok(terrain);  // Return the terrain DTO with a 200 OK status
    }

    /**
     * Retrieve all terrains.
     *
     * @return an iterable collection of TerrainDTOs representing all terrains
     */
    @Operation(summary = "Get all terrains", description = "Retrieve all terrains available in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all terrains"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping  // Maps GET requests to /terrain
    public Iterable<TerrainDTO> getAllTerrain() {
        return terrainService.getAllTerrain();  // Fetch and return all terrain DTOs
    }

    /**
     * Create a new terrain.
     * This method accepts a TerrainDTO, delegates the save operation to the service layer,
     * and returns a 200 OK response upon successful creation.
     *
     * @param terrainDTO the terrain DTO representing the new terrain to be created
     * @return ResponseEntity with 200 OK status indicating successful creation
     */
    @Operation(summary = "Create a new terrain", description = "Create a new terrain resource in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created terrain"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping  // Maps POST requests to /terrain
    public ResponseEntity<Void> saveTerrain(@RequestBody TerrainDTO terrainDTO) {
        terrainService.saveTerrain(terrainDTO);  // Delegate the save operation to the service layer
        return ResponseEntity.ok().build();  // Return a 200 OK status with no content
    }

    /**
     * Update an existing terrain by its ID.
     * If the terrain is not found, a NotFoundException is thrown.
     *
     * @param id the ID of the terrain to update
     * @param terrainDTO the updated terrain data as a DTO
     * @return ResponseEntity with 200 OK status indicating the terrain was successfully updated
     * @throws NotFoundException if the terrain with the specified ID does not exist
     */
    @Operation(summary = "Update an existing terrain", description = "Update a terrain resource by providing the updated data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated terrain"),
            @ApiResponse(responseCode = "404", description = "Terrain ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{id}")  // Maps PUT requests to /terrain/{id}
    public ResponseEntity<Void> updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) throws NotFoundException {
        terrainService.updateTerrain(id, terrainDTO);  // Delegate the update operation to the service layer
        return ResponseEntity.ok().build();  // Return a 200 OK status with no content
    }

    /**
     * Delete a terrain by its ID.
     * This method delegates the deletion operation to the service layer, and returns a 200 OK response
     * after successfully deleting the terrain.
     * If the terrain is not found, a NotFoundException will be thrown.
     *
     * @param id the ID of the terrain to delete
     * @return ResponseEntity with 200 OK status indicating successful deletion
     * @throws NotFoundException if the terrain with the specified ID does not exist
     */
    @Operation(summary = "Delete a terrain by ID", description = "Delete an existing terrain by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted terrain"),
            @ApiResponse(responseCode = "404", description = "Terrain ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")  // Maps DELETE requests to /terrain/{id}
    public ResponseEntity<Void> deleteTerrain(@PathVariable Integer id) throws NotFoundException {
        terrainService.deleteTerrainById(id);  // Delegate the delete operation to the service layer
        return ResponseEntity.ok().build();  // Return a 200 OK status with no content
    }
}
