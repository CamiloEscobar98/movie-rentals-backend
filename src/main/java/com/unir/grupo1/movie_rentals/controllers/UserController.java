package com.unir.grupo1.movie_rentals.controllers;

import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.requests.users.CreateUserRequest;
import com.unir.grupo1.movie_rentals.requests.users.UpdateUserRequest;
import com.unir.grupo1.movie_rentals.services.UserService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return users != null ? ResponseEntity.ok(users) : ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/users")
    public ResponseEntity<User> storeUser(@RequestBody CreateUserRequest request) {
        User userCreated = userService.createUser(request);
        return userCreated != null ? ResponseEntity.status(HttpStatus.CREATED).body(userCreated) : ResponseEntity.badRequest().build();
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        User user = userService.getUser(userId);
        User userCreated = null;
        if (user != null) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            userCreated = userService.updateUser(request, user);
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return userCreated != null ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        Boolean deleted = userService.deleteUser(userId);
        return Boolean.TRUE.equals(deleted) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
