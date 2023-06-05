package com.unir.grupo1.movie_rentals.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_rentals")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private  String name;

    @Column(name = "email", unique = true)
    private  String email;
}
