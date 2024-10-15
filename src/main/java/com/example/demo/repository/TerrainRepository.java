package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import java.io.Serializable;
import com.example.demo.models.Terrain;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends CrudRepository<Terrain, Long> {
}
