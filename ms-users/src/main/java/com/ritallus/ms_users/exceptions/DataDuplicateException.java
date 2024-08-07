package com.ritallus.ms_users.exceptions;

import com.ritallus.ms_users.utils.MessageResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDuplicateException extends RuntimeException {

    private String description;

    public DataDuplicateException(String exception) {
        super(exception);
    }

    public DataDuplicateException(String message, Exception exception) {
        super(message, exception);
    }

    public DataDuplicateException(MessageResponse message) {
        super(message.getMessage());
        this.description = message.getDescription();
    }

}
