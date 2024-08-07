package com.ritallus.ms_users.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDto {

    private Long id;
    private String fileName;
    private String url;
    private Long userId;
    private UserDto user;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
