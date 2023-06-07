package com.unir.grupo1.movie_rentals.repositories;

import com.unir.grupo1.movie_rentals.models.RentalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface RentalDetailRepository extends JpaRepository<RentalDetail, Long> {
    List<RentalDetail> findByRentalId(Long rentalId);

    RentalDetail findByRentalIdAndMovieId (Long rentalId, Long movieId);
}
