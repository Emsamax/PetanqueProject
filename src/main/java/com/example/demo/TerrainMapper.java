package com.example.demo;

import com.example.demo.dto.TerrainDTO;
import com.example.demo.models.Terrain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TerrainMapper {
    TerrainDTO toDTO(Terrain terrain);

    Terrain toEntity(TerrainDTO terrainDTO);
}


