package com.unir.grupo1.movie_rentals.requests.rental_details;

import com.unir.grupo1.movie_rentals.requests.AbstractRequest;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateRentalDetailRequest extends AbstractRequest {
    private @Getter String movie_id;

    public Boolean hasMovie() {
        return this.hasLength(this.getMovie_id());
    }

}
