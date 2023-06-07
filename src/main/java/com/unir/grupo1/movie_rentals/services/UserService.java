package com.unir.grupo1.movie_rentals.services;

import com.unir.grupo1.movie_rentals.interfaces.UserServiceInterface;
import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.repositories.UserRepository;
import com.unir.grupo1.movie_rentals.requests.users.CreateUserRequest;
import com.unir.grupo1.movie_rentals.requests.users.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? null : users;
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(Long.valueOf(userId)).orElse(null);
    }

    @Override
    public User createUser(CreateUserRequest request) {
        if (request != null && request.hasName() && request.hasEmail()) {
            User user = User.builder().name(request.getName()).email(request.getEmail()).build();
            return userRepository.save(user);
        }
        return null;
    }

    public User updateUser(UpdateUserRequest request, User user) {
        if (request != null && request.hasName() && request.hasEmail()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public Boolean deleteUser(String userId) {
        User user = this.getUser(userId);
        if (user != null) {
            userRepository.delete(user);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}