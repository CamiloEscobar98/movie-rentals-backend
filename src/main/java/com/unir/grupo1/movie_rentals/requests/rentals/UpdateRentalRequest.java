package com.unir.grupo1.movie_rentals.requests.rentals;

import com.unir.grupo1.movie_rentals.repositories.UserRepository;
import com.unir.grupo1.movie_rentals.requests.AbstractRequest;
import lombok.Getter;

public class UpdateRentalRequest extends AbstractRequest {
    private @Getter String user_id;
    private @Getter Float total;
    private @Getter String rented_at;
    private @Getter String rented_to;

    public Boolean hasUser() {
        return this.hasLength(this.user_id.trim());
    }

    public Boolean hasTotal() {
        return this.hasLength(String.valueOf(this.total).trim());
    }

    public Boolean hasRentendAt() {
        return this.hasLength(this.rented_at.trim());
    }

    public Boolean hasRentendTo() {
        return this.hasLength(this.rented_to.trim());
    }
}
