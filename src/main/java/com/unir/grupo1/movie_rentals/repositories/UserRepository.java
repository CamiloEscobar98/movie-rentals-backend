package com.unir.grupo1.movie_rentals.repositories;

import com.unir.grupo1.movie_rentals.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
