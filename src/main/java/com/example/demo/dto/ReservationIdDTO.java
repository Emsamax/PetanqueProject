package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Data Transfer Object for ReservationId.
 */
@Data
public class ReservationIdDTO {
    private Integer utilisateurId;
    private Integer terrainId;
}
