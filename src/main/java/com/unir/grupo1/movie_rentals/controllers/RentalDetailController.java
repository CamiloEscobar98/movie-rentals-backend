package com.unir.grupo1.movie_rentals.controllers;

import com.unir.grupo1.movie_rentals.models.RentalDetail;
import com.unir.grupo1.movie_rentals.requests.rental_details.CreateRentalDetailRequest;
import com.unir.grupo1.movie_rentals.services.RentalDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RentalDetailController {
    private final RentalDetailService rentalDetailService;

    @GetMapping("/rentals/{rentalId}/movies")
    public ResponseEntity<Map<String, Object>> index(@PathVariable String rentalId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        List<RentalDetail> rental_details = new ArrayList<>();
        try {
            rental_details = rentalDetailService.getRentalDetails(rentalId);
            statusCode = HttpStatus.OK;
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", ex.getMessage());
        } catch (Exception e) {
            jsonResponse.put("exception_message", e.getMessage());
        }
        jsonResponse.put("data", rental_details);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @PostMapping("rentals/{rentalId}/movies")
    public ResponseEntity<Map<String, Object>> store(@RequestBody CreateRentalDetailRequest request, @PathVariable String rentalId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha registrado correctamente";
        RentalDetail rentalDetail = null;
        try {
            rentalDetail = rentalDetailService.createRentalDetail(request, rentalId);
            statusCode = HttpStatus.OK;
            message = "Se ha registrado correctamente la pelicula en la renta.";
        } catch (ResponseStatusException ex) {
            jsonResponse.put("exception_message", "ResponseStatusException:" + ex.getMessage());
            statusCode = (HttpStatus) ex.getStatusCode();
        } catch (Exception e) {
            jsonResponse.put("exception_message", "Exception:" + e.getMessage());
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        jsonResponse.put("data", rentalDetail);
        jsonResponse.put("message", message);
        return ResponseEntity.status(statusCode).body(jsonResponse);
    }

    @DeleteMapping("/rentals/{rentalId}/movies/{movieId}")
    public ResponseEntity<Map<String, Object>> destroy(@PathVariable String rentalId, @PathVariable String movieId) {
        Map<String, Object> jsonResponse = new HashMap<>();
        HttpStatus statusCode = null;
        String message = "No se ha eliminado correctamente.";

        try {
            RentalDetail rentalDetail = rentalDetailService.getByRentailMovie(rentalId, movieId);
            rentalDetailService.deleteRentalDetail(String.valueOf(rentalDetail.getId()));
            statusCode = HttpStatus.OK;
            message = "Se ha eliminado correctamente";
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
