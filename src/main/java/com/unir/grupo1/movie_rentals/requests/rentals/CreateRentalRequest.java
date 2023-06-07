package com.unir.grupo1.movie_rentals.requests.rentals;

import com.unir.grupo1.movie_rentals.requests.AbstractRequest;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateRentalRequest extends AbstractRequest {
    private @Getter Integer user_id;
    private @Getter Float total;
    private @Getter String rented_at;
    private @Getter String rented_to;
    // private UserRepository userRepository;

    public Boolean hasUser() {
        return this.hasLength(String.valueOf(this.user_id).trim());
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

    /** public Boolean userExist() {
     return userRepository.findById(Long.valueOf(this.user_id)).isPresent();
     } **/
}
