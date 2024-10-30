package com.example.demo.mappers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.models.Terrain;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between Terrain and TerrainDTO.
 */
@Mapper(componentModel = "spring")
public interface TerrainMapper {
    TerrainDTO toDTO(Terrain terrain);

    Terrain toEntity(TerrainDTO terrainDTO);
}
