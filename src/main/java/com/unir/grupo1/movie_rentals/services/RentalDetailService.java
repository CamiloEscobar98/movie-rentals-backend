package com.unir.grupo1.movie_rentals.services;

import com.unir.grupo1.movie_rentals.interfaces.RentalDetailServiceInterface;
import com.unir.grupo1.movie_rentals.models.RentalDetail;
import com.unir.grupo1.movie_rentals.repositories.RentalDetailRepository;
import com.unir.grupo1.movie_rentals.requests.rental_details.CreateRentalDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalDetailService implements RentalDetailServiceInterface {
    @Autowired
    private RentalDetailRepository rentalDetailRepository;

    @Override
    public RentalDetail createRentalDetail(CreateRentalDetailRequest request, String rentalId) {
        System.out.println(rentalId);
        if (request != null && request.hasMovie()) {
            RentalDetail rentalDetail = RentalDetail.builder().
                    rentalId(Integer.valueOf(rentalId)).
                    movieId(Integer.valueOf(request.getMovie_id())).build();
            return rentalDetailRepository.save(rentalDetail);
        }
        return null;
    }

    @Override
    public List<RentalDetail> getRentalDetails(String rentailDetailId) {
        List<RentalDetail> rentalDetails = rentalDetailRepository.findByRentalId(Long.valueOf(rentailDetailId));
        return rentalDetails.isEmpty() ? new ArrayList<>() : rentalDetails;
    }

    @Override
    public Boolean deleteRentalDetail(String rentalDetailId) {
        RentalDetail rentalDetail = rentalDetailRepository.findById(Long.valueOf(rentalDetailId)).orElse(null);
        if (rentalDetail != null) {
            rentalDetailRepository.delete(rentalDetail);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public RentalDetail getByRentailMovie(String rentalId, String movieId) {
        return rentalDetailRepository.findByRentalIdAndMovieId(Long.valueOf(rentalId), Long.valueOf(movieId));
    }
}
