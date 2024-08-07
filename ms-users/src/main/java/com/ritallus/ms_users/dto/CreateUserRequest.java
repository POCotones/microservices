package com.ritallus.ms_users.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateUserRequest {

    private String names;
    private String lastnames;
    private String email;
}
