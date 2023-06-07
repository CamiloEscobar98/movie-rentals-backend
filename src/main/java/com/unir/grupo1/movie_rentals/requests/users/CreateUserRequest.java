package com.unir.grupo1.movie_rentals.requests.users;

import com.unir.grupo1.movie_rentals.requests.AbstractRequest;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserRequest extends AbstractRequest {
    private @Getter String name;
    private @Getter String email;

    public Boolean hasName() {
        return this.hasLength(this.getName().trim());
    }

    public Boolean hasEmail() {
        return this.hasLength(this.getEmail().trim());
    }
}
