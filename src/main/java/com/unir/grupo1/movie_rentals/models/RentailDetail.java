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
public class RentailDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Rental.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Rental user;

    @Column(name = "movie_id")
    private Integer movie_id;
}
