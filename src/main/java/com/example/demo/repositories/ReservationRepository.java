package com.example.demo.repositories;

import com.example.demo.models.Reservation;
import com.example.demo.models.ReservationId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Reservation entities.
 * This interface extends CrudRepository to provide CRUD operations on Reservation entities,
 * using a composite key (ReservationId) as the ID.
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, ReservationId> {
}
