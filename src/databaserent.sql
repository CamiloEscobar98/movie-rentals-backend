USE movie_rentals;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME,
    CONSTRAINT UNIQUE_USERS_NAME UNIQUE (name),
    CONSTRAINT UNIQUE_USERS_EMAIL UNIQUE (email)
);

CREATE TABLE rentals(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    rented_at DATE NOT NULL,
    rented_to DATE NOT NULL,
    total DECIMAL(10, 2),
    created_by INT NULL,
    modified_by INT NULL,
    created_at DATETIME NULL,
    updated_at DATETIME NULL,
    CONSTRAINT FK_RENTALS_USERS FOREIGN KEY (user_id) REFERENCES users(id)
);

create table rental_details(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rental_id INT NOT NULL,
    movie_id INT NOT NULL,
    CONSTRAINT FK_RENTALS_RENTAL_DETAILS FOREIGN KEY (rental_id) REFERENCES rentals(id),
    CONSTRAINT UNIQUE_RENTAL_DETAILS UNIQUE (rental_id, movie_id)
);