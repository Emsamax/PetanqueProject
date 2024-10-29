package com.example.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TerrainDTO {

    private Integer id;
    private String nom;
    private Integer quantite;
    private String description;
    private String pointGeo;
}
