package com.unir.grupo1.movie_rentals.interfaces;

import com.unir.grupo1.movie_rentals.models.RentalDetail;
import com.unir.grupo1.movie_rentals.requests.rental_details.CreateRentalDetailRequest;

import java.util.List;

public interface RentalDetailServiceInterface {
    RentalDetail createRentalDetail(CreateRentalDetailRequest request, String rentalId);

    List<RentalDetail> getRentalDetails(String rentailDetailId);

    Boolean deleteRentalDetail(String rentailDetailId);

}
