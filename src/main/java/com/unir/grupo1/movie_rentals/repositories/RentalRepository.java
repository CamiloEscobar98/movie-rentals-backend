package com.unir.grupo1.movie_rentals.repositories;

import com.unir.grupo1.movie_rentals.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUser(String user_id);
}
