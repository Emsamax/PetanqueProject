package com.example.demo.repository;

import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import com.example.demo.models.Terrain;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.id= :id")
    void deleteById(ReservationId id);
}
