package com.ritallus.ms_users.utils;

import lombok.Getter;

@Getter
public enum MessageResponse {
    MISSING_REQUIRED_FIELD("MISSING_REQUIRED_FIELD", "Required field is missing"),

    /*NOT_FOUND_EXCEPTION*/
    USER_NOT_FOUND_EXCEPTION("USER_NOT_FOUND_EXCEPTION", "User could not be found"),
    FILE_NOT_FOUND_EXCEPTION("FILE_NOT_FOUND_EXCEPTION", "File could not be found"),

    FILE_EXISTS_EXCEPTION("FILE_EXISTS_EXCEPTION", "File already exists"),
    USER_EXISTS_EXCEPTION("USER_EXISTS_EXCEPTION", "User already exists"),
    ;

    private final String message;
    private final String description;

    MessageResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
