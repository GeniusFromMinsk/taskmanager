package com.itclopedia.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String entityType, Number id) {
        super(String.format(ExceptionMessages.ENTITY_ALREADY_EXISTS, entityType, id));
    }

}
