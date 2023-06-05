package com.unir.grupo1.movie_rentals.services;

import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.requests.CreateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(CreateUserRequest request);
    List<User> getUsers();
    User getUser(String userId);
    Boolean deleteUser(String userId);
}
