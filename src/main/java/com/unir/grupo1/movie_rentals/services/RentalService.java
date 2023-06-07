package com.unir.grupo1.movie_rentals.services;

import com.unir.grupo1.movie_rentals.interfaces.RentalServiceInterface;
import com.unir.grupo1.movie_rentals.models.Rental;
import com.unir.grupo1.movie_rentals.repositories.RentalRepository;
import com.unir.grupo1.movie_rentals.requests.rentals.CreateRentalRequest;
import com.unir.grupo1.movie_rentals.requests.rentals.UpdateRentalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RentalService implements RentalServiceInterface {
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental createRental(CreateRentalRequest request) {

        if (request != null && request.hasUser() && request.hasTotal()
                && request.hasRentendAt() && request.hasRentendTo()
            // && request.userExist()
        ) {
            Date rentedAtParsed = null;
            Date rentedToParsed = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat();
                rentedAtParsed = sdf.parse(request.getRented_at());
                rentedToParsed = sdf.parse(request.getRented_to());
            } catch (ParseException e) {
                return null;
            }
            Rental rental = Rental.builder()
                    .user_id(Integer.valueOf(request.getUser_id()))
                    .rented_at(rentedAtParsed)
                    .rented_to(rentedToParsed)
                    .build();
        }
        return null;
    }

    @Override
    public List<Rental> getRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.isEmpty() ? null : rentals;
    }

    @Override
    public Rental getRental(String rentalId) {
        return rentalRepository.findById(Long.valueOf(rentalId)).orElse(null);
    }

    public Rental updateRental(UpdateRentalRequest request, Rental rental) {
        if (request != null && request.hasUser() && request.hasTotal()
                && request.hasRentendAt() && request.hasRentendTo() && request.userExist()) {
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
