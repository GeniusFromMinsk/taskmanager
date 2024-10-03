package com.itclopedia.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityStringNotFoundException extends RuntimeException{

    public EntityStringNotFoundException(String entityType, String id) {
        super(String.format(ExceptionMessages.ENTITY_IS_NOT_FOUND, entityType, id));
    }
}
