package com.unir.grupo1.movie_rentals.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "total")
    private Float total;

    @Column(name = "rented_at")
    @Temporal(TemporalType.DATE)
    private Date rented_at;

    @Column(name = "rented_to")
    @Temporal(TemporalType.DATE)
    private Date rented_to;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
