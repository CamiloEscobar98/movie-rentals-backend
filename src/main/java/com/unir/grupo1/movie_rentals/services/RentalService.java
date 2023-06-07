package com.unir.grupo1.movie_rentals.services;

import com.unir.grupo1.movie_rentals.interfaces.RentalServiceInterface;
import com.unir.grupo1.movie_rentals.models.Rental;
import com.unir.grupo1.movie_rentals.repositories.RentalRepository;
import com.unir.grupo1.movie_rentals.requests.rentals.CreateRentalRequest;
import com.unir.grupo1.movie_rentals.requests.rentals.UpdateRentalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService implements RentalServiceInterface {
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental createRental(CreateRentalRequest request) {

        if (request != null && request.hasUser() && request.hasTotal() && request.hasRentendAt() && request.hasRentendTo()) {
            Rental rental = Rental.builder().user_id(Integer.valueOf(request.getUser_id())).total(Float.valueOf(request.getTotal())).rented_at(request.getRented_at()).rented_to(request.getRented_to()).build();
            return rentalRepository.save(rental);
        }
        return null;
    }

    @Override
    public List<Rental> getRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.isEmpty() ? new ArrayList<>() : rentals;
    }

    @Override
    public Rental getRental(String rentalId) {
        return rentalRepository.findById(Long.valueOf(rentalId)).orElse(null);
    }

    @Override
    public Rental updateRental(UpdateRentalRequest request, Rental rental) {
        if (request != null && request.hasUser() && request.hasTotal() && request.hasRentendAt() && request.hasRentendTo()) {
            return rentalRepository.save(rental);
        }
        return null;
    }

    @Override
    public Boolean deleteRental(String rentalId) {
        Rental rental = this.getRental(rentalId);
        if (rental != null) {
            rentalRepository.delete(rental);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
