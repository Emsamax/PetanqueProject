package com.example.demo.services;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.mappers.TerrainMapper;
import com.example.demo.models.Terrain;
import com.example.demo.repositories.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing Terrain entities.
 */
@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;
    private final TerrainMapper terrainMapper;

    @Autowired
    public TerrainService(TerrainRepository terrainRepository, TerrainMapper terrainMapper) {
        this.terrainRepository = terrainRepository;
        this.terrainMapper = terrainMapper;
    }

    /**
     * Retrieve all terrains.
     */
    public List<TerrainDTO> getAllTerrains() {
        return terrainRepository.findAll().stream()
                .map(terrainMapper::toDTO).toList();
    }

    /**
     * Retrieve a terrain by its ID.
     */
    public Optional<TerrainDTO> getTerrainById(Integer id) {
        return terrainRepository.findById(id).map(terrainMapper::toDTO);
    }

    /**
     * Create or update a terrain.
     */
    public TerrainDTO saveTerrain(TerrainDTO terrainDTO) {
        Terrain terrain = terrainMapper.toEntity(terrainDTO);
        Terrain savedTerrain = terrainRepository.save(terrain);
        return terrainMapper.toDTO(savedTerrain);
    }

    /**
     * Delete a terrain by its ID.
     */
    public void deleteTerrain(Integer id) {
        terrainRepository.deleteById(id);
    }
}
