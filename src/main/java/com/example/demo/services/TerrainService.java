package com.example.demo.services;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.mappers.TerrainMapper;
import com.example.demo.repositories.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
     * Retrieve a terrain by its ID.
     */
    public Optional<TerrainDTO> getTerrainById(Integer id) throws ChangeSetPersister.NotFoundException {
        // Si le terrain n'est pas trouvé, une exception NotFound est lancée
        return Optional.ofNullable(terrainRepository.findById(id)
                .map(terrainMapper::toDTO)
                .orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    /**
     * Retrieve all terrains.
     */
    public Iterable<TerrainDTO> getAllTerrains() {
        return terrainRepository.findAll().stream()
                .map(terrainMapper::toDTO).toList();
    }

    /**
     * Create or update a terrain.
     */
    public void saveTerrain(TerrainDTO terrainDTO) {
        terrainRepository.save(terrainMapper.toEntity(terrainDTO));
    }

    /**
     * Update an existing terrain.
     */
    public void updateTerrain(TerrainDTO terrainDTO) throws ChangeSetPersister.NotFoundException {
        // Vérifie si le terrain existe avant de procéder à la mise à jour
        if (!terrainRepository.existsById(terrainDTO.getId())) {
            throw new ChangeSetPersister.NotFoundException();
        }
        // Sauvegarde le terrain mis à jour
        terrainRepository.save(terrainMapper.toEntity(terrainDTO));
    }

    /**
     * Delete a terrain by its ID.
     */
    public void deleteTerrainById(Integer id) throws ChangeSetPersister.NotFoundException {
        // Vérifie si le terrain existe avant de le supprimer
        if (!terrainRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        terrainRepository.deleteById(id);
    }
}
