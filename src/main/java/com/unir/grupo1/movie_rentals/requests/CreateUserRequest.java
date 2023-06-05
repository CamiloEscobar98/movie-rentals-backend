package com.unir.grupo1.movie_rentals.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;
}
