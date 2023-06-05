package com.unir.grupo1.movie_rentals.interfaces;

import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.requests.CreateUserRequest;

import java.util.List;

public interface UserServiceInterface {
    User createUser(CreateUserRequest request);
    List<User> getUsers();
    User getUser(String userId);
    Boolean deleteUser(String userId);
}
