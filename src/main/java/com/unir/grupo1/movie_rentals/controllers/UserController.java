package com.unir.grupo1.movie_rentals.controllers;

import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.requests.users.CreateUserRequest;
import com.unir.grupo1.movie_rentals.requests.users.UpdateUserRequest;
import com.unir.grupo1.movie_rentals.services.UserService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        List<User> users = new ArrayList<>();
        try {
            users = userService.getUsers();
            statusCode = HttpStatus.OK;
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", ex.getMessage());
        } catch (Exception e) {
            jsonResponse.put("exception_message", e.getMessage());
        }
        jsonResponse.put("data", users);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable String userId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        User user = null;
        statusCode = HttpStatus.NOT_FOUND;
        try {
            user = userService.getUser(userId);
            statusCode = HttpStatus.OK;
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", user);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, Object>> store(@RequestBody CreateUserRequest request) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha registrado correctamente";
        User userCreated = null;
        statusCode = HttpStatus.NOT_FOUND;
        try {
            userCreated = userService.createUser(request);
            statusCode = HttpStatus.OK;
            message = String.format("Se ha registrado correctamente el usuario %s.", userCreated.getName());
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", userCreated);
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody UpdateUserRequest request, @PathVariable String userId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha actualizado correctamente";
        User user = userService.getUser(userId);
        User userUpdated = null;
        statusCode = HttpStatus.NOT_FOUND;
        try {
            userUpdated = userService.updateUser(request, user);
            statusCode = HttpStatus.OK;
            message = String.format("Se ha actualizado correctamente el usuario %s.", userUpdated.getName());
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", userUpdated);
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Map<String, Object>> destroy(@PathVariable String userId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha eliminado correctamente.";
        try {
            User user = userService.getUser(userId);
            userService.deleteUser(userId);
            statusCode = HttpStatus.OK;
            message = String.format("Se ha eliminado correctamente %s.", user.getName());
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }
}
