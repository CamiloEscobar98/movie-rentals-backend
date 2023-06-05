package com.unir.grupo1.movie_rentals.requests;

import org.springframework.util.StringUtils;

abstract class AbstractRequest {

    public Boolean hasLength(String value){
        return StringUtils.hasLength(value);
    }

}
