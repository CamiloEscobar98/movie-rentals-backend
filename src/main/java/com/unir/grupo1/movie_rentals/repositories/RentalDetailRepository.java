package com.unir.grupo1.movie_rentals.repositories;

import com.unir.grupo1.movie_rentals.models.RentailDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalDetailRepository extends JpaRepository<RentailDetail, Long> {
    //List<RentailDetail> findByRental(String rental_id);
}
