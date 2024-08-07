package com.ritallus.ms_users.controllers;

import com.ritallus.ms_users.dto.CreateUserRequest;
import com.ritallus.ms_users.dto.UserDto;
import com.ritallus.ms_users.dto.UserFilesResponse;
import com.ritallus.ms_users.facades.UserFacade;
import com.ritallus.ms_users.utils.StandardResponse;
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
@RequestMapping("/users")
public class UserController {

    private final UserFacade facade;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/create-user")
    @Operation(summary = "Create user with files")
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

    @GetMapping("/search-users-with-files/{email}")
    @Operation(summary = "Search users with files")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data searched successfully"),
            @ApiResponse(responseCode = "400", description = "The request is invalid"),
            @ApiResponse(responseCode = "500", description = "Internal error processing response"),
    })
    public ResponseEntity<StandardResponse<UserFilesResponse>> findUserWithFiles(@PathVariable String email) {
        var result = facade.findUserWithFiles(email);
        return ResponseEntity.ok(new StandardResponse<>(result));
    }
}