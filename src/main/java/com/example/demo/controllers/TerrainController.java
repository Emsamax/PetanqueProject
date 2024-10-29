package com.example.demo.controllers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.services.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling Terrain-related requests.
 */
@RestController
@RequestMapping("/api/terrains")
public class TerrainController {

    private final TerrainService terrainService;

    @Autowired
    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    /**
     * Retrieve all terrains.
     */
    @GetMapping
    public List<TerrainDTO> getAllTerrains() {
        return terrainService.getAllTerrains();
    }

    /**
     * Retrieve a terrain by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TerrainDTO> getTerrainById(@PathVariable Integer id) {
        Optional<TerrainDTO> terrainDTO = terrainService.getTerrainById(id);
        return terrainDTO.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new terrain.
     */
    @PostMapping
    public TerrainDTO createTerrain(@RequestBody TerrainDTO terrainDTO) {
        return terrainService.saveTerrain(terrainDTO);
    }

    /**
     * Update an existing terrain.
     */
    @PutMapping("/{id}")
    public ResponseEntity<TerrainDTO> updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) {
        terrainDTO.setId(id);
        return ResponseEntity.ok(terrainService.saveTerrain(terrainDTO));
    }

    /**
     * Delete a terrain by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Integer id) {
        terrainService.deleteTerrain(id);
        return ResponseEntity.noContent().build();
    }
}
