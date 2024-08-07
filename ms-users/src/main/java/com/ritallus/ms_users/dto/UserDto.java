package com.ritallus.ms_users.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;
    private String names;
    private String lastnames;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
