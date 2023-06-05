package com.unir.grupo1.movie_rentals.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest extends AbstractRequest {
    private String name;
    private String email;

    public Boolean hasName() {
        return this.hasLength(this.getName().trim());
    }

    public Boolean hasEmail(){
        return this.hasLength(this.getEmail().trim());
    }
}
