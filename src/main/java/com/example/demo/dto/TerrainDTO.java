package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for the Terrain entity.
 * This class is used to transfer data about a petanque ground between layers (e.g., between controllers and services).
 * It includes information such as the ground's name, quantity, description, and geographic location.
 */
@Data
public class TerrainDTO {

    /**
     * The identifier for the petanque ground.
     * This field is typically excluded when creating a new terrain, as it is auto-generated.
     */
    @Schema(description = "The unique identifier of the petanque ground (auto-generated). Typically excluded in creation requests.")
    private Integer id;

    /**
     * The name of the petanque ground.
     * This field cannot be null or blank and has a maximum length of 100 characters.
     */
    @NotBlank(message = "The name of the petanque ground cannot be empty.")
    @Schema(description = "The name of the petanque ground (cannot be null or blank, max 100 characters).")
    private String nom;

    /**
     * The quantity of petanque grounds available.
     * This field cannot be null and must be greater than or equal to zero.
     */
    @NotNull(message = "The quantity cannot be null.")
    @Min(value = 0, message = "The quantity must be greater than or equal to zero.")
    @Schema(description = "The quantity of petanque grounds (cannot be null, must be >= 0).")
    private Integer quantite;

    /**
     * A description of the petanque ground.
     * This field is optional and has a maximum length of 100 characters.
     */
    @Schema(description = "A description of the petanque ground (max 100 characters).")
    private String description;

    /**
     * The geographic point of the petanque ground.
     * This field cannot be null or blank and has a maximum length of 100 characters.
     */
    @NotBlank(message = "The geographic point cannot be empty.")
    @Schema(description = "The geographic point of the petanque ground (cannot be null or blank, max 100 characters).")
    private String pointGeo;
}
