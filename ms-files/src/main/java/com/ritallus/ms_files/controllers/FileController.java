package com.ritallus.ms_files.controllers;


import com.ritallus.ms_files.dto.FileDto;
import com.ritallus.ms_files.facades.FileFacade;
import com.ritallus.ms_files.utils.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileFacade facade;
    private final Logger log = LoggerFactory.getLogger(FileController.class);

    public FileController(FileFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/upload-files")
    @Operation(summary = "Upload files")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data created successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<UserDto>> createUser(@RequestPart("request") CreateUserRequest request,
                                                                @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        var result = facade.createUser(request, files);
        return ResponseEntity.ok(new StandardResponse<>(result));
    }
}