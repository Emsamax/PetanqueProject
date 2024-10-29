package com.example.demo.dto;

import com.example.demo.models.ReservationId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ReservationDTO {
    private ReservationId id;
    private Integer reservation;
}
