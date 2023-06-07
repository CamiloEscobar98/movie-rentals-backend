package com.unir.grupo1.movie_rentals.interfaces;

import com.unir.grupo1.movie_rentals.models.Rental;
import com.unir.grupo1.movie_rentals.requests.rentals.CreateRentalRequest;

import java.text.ParseException;
import java.util.List;

public interface RentalServiceInterface {
    Rental createRental(CreateRentalRequest request) throws ParseException;
    List<Rental> getRentals();
    Rental getRental(String rentalId);
    Boolean deleteRental(String rentalId);
}
