package com.ritallus.ms_users.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserFilesResponse {

    private UserDto user;
    private List<FileDto> files;
}
