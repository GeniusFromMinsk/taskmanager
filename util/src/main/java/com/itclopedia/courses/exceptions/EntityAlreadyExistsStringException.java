package com.itclopedia.courses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistsStringException extends RuntimeException {

    public EntityAlreadyExistsStringException(String entityType, String type) {
        super(String.format(ExceptionMessages.ENTITY_ALREADY_EXISTS, entityType, type));
    }
}
