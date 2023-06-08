# Microservicio [Rentas] MovieApp

## Endpoints de la API Rest

### Recurso Usuarios

#### 1. http://localhost:8080/users (GET)

Lista de todos los usuarios del sistema. Usuarios del tipo @Cliente, que se relaciona
directamente con los alquileres de peliculas.

Su modelo de respuesta es el siguiente:

```
{
  "data": [
    {
      "id": 2,
      "name": " Felipe Yáñez",
      "email": "felipeya2000@gmail.com",
      "created_at": "2023-06-07T03:50:02.000+00:00",
      "updated_at": "2023-06-07T03:50:02.000+00:00"
    },
    {
      "id": 3,
      "name": " Sebastian Yáñez",
      "email": "sebasgamer@gmail.com",
      "created_at": "2023-06-07T19:46:15.000+00:00",
      "updated_at": "2023-06-07T19:46:15.000+00:00"
    },
    {
      "id": 12,
      "name": " Andrés Yáñez",
      "email": "camilo_escobar2398@outlook.com",
      "created_at": "2023-06-07T23:50:47.000+00:00",
      "updated_at": "2023-06-07T23:50:47.000+00:00"
    }
  ]
}
```

#### 2. http://localhost:8080/users/{userId} (GET)

Por medio de un identificador de usuario ID, es posible buscar la información del usuario.

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 2,
    "name": " Felipe Yáñez",
    "email": "felipeya2000@gmail.com",
    "created_at": "2023-06-07T03:50:02.000+00:00",
    "updated_at": "2023-06-07T03:50:02.000+00:00"
  }
}
```

#### 3. http://localhost:8080/users (POST)

Para poder guardar la información de un usuario es necesario mandar en el body o el cuerpo de la petición,
información como el nombre y el correo electrónico del usuario. Acá un ejemplo:

```
{
  "name": " Andrés Yáñez",
  "email": "camilo_escobar2398@outlook.com"
}
```

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 12,
    "name": " Andrés Yáñez",
    "email": "camilo_escobar2398@outlook.com",
    "created_at": "2023-06-07T23:50:46.755+00:00",
    "updated_at": "2023-06-07T23:50:46.755+00:00"
  },
  "message": "Se ha registrado correctamente el usuario  Andrés Yáñez."
}
```

#### 4. http://localhost:8080/users/{userId} (PUT)

Para poder actualizar la información de un usuario es necesario pasar el identificador del usuario en la url y en su
cuerpo de petición, colocar la información a actualizar, Acá un ejemplo:

```
{
  "name": "Andrés Camilo Yáñez Escobar",
  "email": "andres_escobar2398@outlook.com"
}
```

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 12,
    "name": "Andrés Camilo Yáñez Escobar",
    "email": "andres_escobar2398@outlook.com",
    "created_at": "2023-06-07T23:50:47.000+00:00",
    "updated_at": "2023-06-07T23:55:23.177+00:00"
  },
  "message": "Se ha actualizado correctamente el usuario Andrés Camilo Yáñez Escobar."
}
```

#### 5. http://localhost:8080/users/{userId} (DELETE)

Para poder eliminar un usuario del sistema, es necesario pasar su identificador de usuario por medio de la url. Con esto
se hará una validación de si existe y si puede eliminarse.

Su modelo de respuesta es la siguiente:

```
{
  "message": "Se ha eliminado correctamente  Sebastian Yáñez."
}
```

### Recurso Rentas

#### 1. http://localhost:8080/rentals (GET)

Lista de todos las rentas del sistema.

Su modelo de respuesta es el siguiente:

```
{
  "data": [
    {
      "id": 1,
      "user_id": 1,
      "total": 5000.0,
      "rented_at": "2023-06-07",
      "rented_to": "2023-06-10",
      "created_at": "2023-06-07T23:31:20.000+00:00",
      "updated_at": "2023-06-07T23:31:20.000+00:00",
      "user": null
    }
  ]
}
```

#### 2. http://localhost:8080/rentals/{rentalId} (GET)

Por medio de un identificador de la renta ID, es posible buscar la información de esa renta de peliculas.

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 1,
    "user_id": 2,
    "total": 5000.0,
    "rented_at": "2023-06-07",
    "rented_to": "2023-06-10",
    "created_at": "2023-06-07T23:31:20.000+00:00",
    "updated_at": "2023-06-07T23:31:20.000+00:00",
    "user": {
      "id": 2,
      "name": " Felipe Yáñez",
      "email": "felipeya2000@gmail.com",
      "created_at": "2023-06-07T03:50:02.000+00:00",
      "updated_at": "2023-06-07T03:50:02.000+00:00"
    }
  }
}
```

#### 3. http://localhost:8080/rentals (POST)

Para poder guardar la información de una renta es necesario mandar en el body o el cuerpo de la petición,
información como el usuario que hace la renta, sus fechas y su costo. Acá un ejemplo:

```
{
  "user_id" : 1,
  "rented_at" : "2023/06/07",
  "rented_to" : "2023/06/10",
  "total" : 5000
}
```

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 2,
    "user_id": 1,
    "total": 5000.0,
    "rented_at": "2023/06/07",
    "rented_to": "2023/06/10",
    "created_at": "2023-06-07T23:31:19.894+00:00",
    "updated_at": "2023-06-07T23:31:19.894+00:00",
    "user": null
  },
  "message": "Se ha registrado correctamente la renta."
}
```

#### 4. http://localhost:8080/rentals/{rentalId} (PUT)

Para poder actualizar la información de una renta es necesario pasar el identificador de la renta en la url y en su
cuerpo de petición, colocar la información a actualizar, Acá un ejemplo:

```
{
  "user_id" : 1,
  "rented_at" : "2023/06/07",
  "rented_to" : "2023/06/23",
  "total" : 5000
}
```

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 1,
    "user_id": 1,
    "total": 5000.0,
    "rented_at": "2023/06/07",
    "rented_to": "2023/06/23",
    "created_at": "2023-06-07T23:31:20.000+00:00",
    "updated_at": "2023-06-08T00:00:32.779+00:00",
    "user": {
      "id": 2,
      "name": " Felipe Yáñez",
      "email": "felipeya2000@gmail.com",
      "created_at": "2023-06-07T03:50:02.000+00:00",
      "updated_at": "2023-06-07T03:50:02.000+00:00"
    }
  },
  "message": "Se ha actualizado correctamente la renta."
}
```

#### 5. http://localhost:8080/rentals/{rentalId} (DELETE)

Para poder eliminar una renta del sistema, es necesario pasar su identificador de renta por medio de la url. Con esto
se hará una validación de si existe y si puede eliminarse.

Su modelo de respuesta es la siguiente:

```
{
  "message": "Se ha eliminado correctamente."
}
```

### Recurso Peliculas Rentadas

#### 1. http://localhost:8080/rentals/{rentalId}/movies (GET)

Lista de todos las peliculas que pertenece a la renta del sistema.

Su modelo de respuesta es el siguiente:

```
{
  "data": [
    {
      "id": 6,
      "rentalId": 1,
      "movieId": 3
    }
  ]
}
```

#### 2. http://localhost:8080/rentals/{rentalId}/movies (POST)

Para poder agregar una pelicula a la lista de peliculas de la renta es necesario colocar el identificador de la renta y
el identificador de la pelicula lo envias por el cuerpo de la petición.

```
{
  "movie_id": 3
}
```

Su modelo de respuesta es el siguiente:

```
{
  "data": {
    "id": 6,
    "rentalId": 1,
    "movieId": 3,
    "rental": null
  },
  "message": "Se ha registrado correctamente la pelicula en la renta."
}
```

#### 5. http://localhost:8080/rentals/{rentalId}/movies/{movieId} (DELETE)

Para poder eliminar o desvincular una pelicula de la lista de peliculas de una renta, es necesario pasar el
identificador de la renta y el identificador de la pelicula.

```
{
  "message": "Se ha eliminado correctamente."
}
```
