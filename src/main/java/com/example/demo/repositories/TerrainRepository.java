package com.example.demo.repositories;

import com.example.demo.models.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Terrain entity.
 */
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
}
