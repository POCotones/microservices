package com.ritallus.ms_files.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileDto {

    private Long id;
    private String fileName;
    private Long UserId;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
