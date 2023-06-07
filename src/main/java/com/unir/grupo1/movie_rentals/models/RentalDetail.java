package com.unir.grupo1.movie_rentals.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "rental_details")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RentalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "movie_id")
    private Integer movieId;
}
