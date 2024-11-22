package com.example.demo.controllers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.services.TerrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling Terrain-related requests.
 */
@RestController
@RequestMapping("/terrain")
public class TerrainController {

    private final TerrainService terrainService;
    private final ServerProperties serverProperties;

    @Autowired
    public TerrainController(TerrainService terrainService, ServerProperties serverProperties) {
        this.terrainService = terrainService;
        this.serverProperties = serverProperties;
    }

    /**
     * Retrieve a terrain by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TerrainDTO> getTerrainById(@PathVariable Integer id) throws Exception {
        Optional<TerrainDTO> terrainDTO = terrainService.getTerrainById(id);
        TerrainDTO terrain = terrainDTO.get();
        return ResponseEntity.ok(terrain);
    }

    /**
     * Retrieve all terrains.
     */
    @GetMapping
    public Iterable<TerrainDTO> getAllTerrain() {
        return terrainService.getAllTerrains();
    }

    /**
     * Create a new terrain.
     */
    @PostMapping
    public ResponseEntity<Void> saveTerrain(@RequestBody TerrainDTO terrainDTO) {
        terrainService.saveTerrain(terrainDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * Update an existing terrain.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTerrain(@PathVariable Integer id, @RequestBody TerrainDTO terrainDTO) throws Exception {
        terrainService.updateTerrain(terrainDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * Delete a terrain by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrain(@PathVariable Integer id) throws Exception {
        terrainService.deleteTerrainById(id);
        return ResponseEntity.ok().build();
    }
}
