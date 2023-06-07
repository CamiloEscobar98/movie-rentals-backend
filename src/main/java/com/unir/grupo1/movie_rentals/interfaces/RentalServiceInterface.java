package com.unir.grupo1.movie_rentals.interfaces;

import com.unir.grupo1.movie_rentals.models.Rental;
import com.unir.grupo1.movie_rentals.requests.rentals.CreateRentalRequest;
import com.unir.grupo1.movie_rentals.requests.rentals.UpdateRentalRequest;

import java.text.ParseException;
import java.util.List;

public interface RentalServiceInterface {
    Rental createRental(CreateRentalRequest request);

    List<Rental> getRentals();

    Rental getRental(String rentalId);

    Rental updateRental(UpdateRentalRequest request, Rental rental);

    Boolean deleteRental(String rentalId);
}
