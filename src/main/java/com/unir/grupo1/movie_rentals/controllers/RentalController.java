package com.unir.grupo1.movie_rentals.controllers;

import com.unir.grupo1.movie_rentals.models.Rental;
import com.unir.grupo1.movie_rentals.models.User;
import com.unir.grupo1.movie_rentals.requests.rentals.CreateRentalRequest;
import com.unir.grupo1.movie_rentals.requests.rentals.UpdateRentalRequest;
import com.unir.grupo1.movie_rentals.requests.users.CreateUserRequest;
import com.unir.grupo1.movie_rentals.requests.users.UpdateUserRequest;
import com.unir.grupo1.movie_rentals.services.RentalService;
import lombok.RequiredArgsConstructor;
import org.hibernate.QueryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("/rentals")
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        List<Rental> rentals = new ArrayList<>();
        try {
            rentals = rentalService.getRentals();
            statusCode = HttpStatus.OK;
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", ex.getMessage());
        } catch (Exception e) {
            jsonResponse.put("exception_message", e.getMessage());
        }
        jsonResponse.put("data", rentals);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @GetMapping("/rentals/{rentalId}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable String rentalId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        Rental rental = null;
        try {
            rental = rentalService.getRental(rentalId);
            statusCode = HttpStatus.OK;
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", rental);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @PostMapping("/rentals")
    public ResponseEntity<Map<String, Object>> store(@RequestBody CreateRentalRequest request) {
        Map<String, Object> jsonResponse = new HashMap<>();
        String message = "No se ha podido registrar la renta de películas";
        HttpStatus statusCode = null;
        Rental rentalCreated = null;
        try {
            rentalCreated = rentalService.createRental(request);
            statusCode = HttpStatus.OK;
            message = "Se ha registrado correctamente la renta.";
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", rentalCreated);
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @PutMapping("/rentals/{rentalId}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody UpdateRentalRequest request, @PathVariable String rentalId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha actualizado correctamente";
        Rental rental = null;
        Rental rentalUpdated = null;
        Date rentedAtParsed = null;
        Date rentedToParsed = null;
        try {
            rental = rentalService.getRental(rentalId);
            SimpleDateFormat sdf = new SimpleDateFormat();
            rentedAtParsed = sdf.parse(request.getRented_at());
            rentedToParsed = sdf.parse(request.getRented_to());
            rental.setUser_id(Integer.valueOf(request.getUser_id()));
            rental.setRented_at(rentedAtParsed);
            rental.setRented_to(rentedToParsed);
            rentalUpdated = rentalService.updateRental(request, rental);
            message = "Se ha actualizado correctamente la renta.";
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", rentalUpdated);
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @DeleteMapping("/rentals/{rentalId}")
    public ResponseEntity<Map<String, Object>> destroy(@PathVariable String rentalId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha eliminado correctamente.";
        try {
            rentalService.deleteRental(rentalId);
            statusCode = HttpStatus.OK;
            message = "Se ha eliminado correctamente la renta.";
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
