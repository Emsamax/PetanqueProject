package com.example.demo.mappers;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.models.Terrain;

import org.mapstruct.Mapper;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Mapper interface for converting between the Terrain entity and its corresponding DTO (TerrainDTO).
 * This interface uses MapStruct to automate the mapping process between the entity and DTO.
 */
@Mapper(componentModel = "spring")
public interface TerrainMapper {

    /**
     * Converts a Terrain entity to its corresponding TerrainDTO.
     *
     * @param terrain the Terrain entity to be converted
     * @return the corresponding TerrainDTO
     */
    @Schema(description = "Converts a Terrain entity to its corresponding TerrainDTO.")
    TerrainDTO toDTO(Terrain terrain);

    /**
     * Converts a TerrainDTO to its corresponding Terrain entity.
     *
     * @param terrainDTO the TerrainDTO to be converted
     * @return the corresponding Terrain entity
     */
    @Schema(description = "Converts a TerrainDTO to its corresponding Terrain entity.")
    Terrain toEntity(TerrainDTO terrainDTO);
}
