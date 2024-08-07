package com.ritallus.ms_users.facades;

import com.ritallus.ms_users.dto.CreateUserRequest;
import com.ritallus.ms_users.dto.FileDto;
import com.ritallus.ms_users.dto.UserDto;
import com.ritallus.ms_users.dto.UserFilesResponse;
import com.ritallus.ms_users.entities.File;
import com.ritallus.ms_users.entities.User;
import com.ritallus.ms_users.mappers.FileMapper;
import com.ritallus.ms_users.mappers.UserMapper;
import com.ritallus.ms_users.services.FileService;
import com.ritallus.ms_users.services.UserService;
import com.ritallus.ms_users.utils.CustomUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserFacade {
    private final Logger log = LoggerFactory.getLogger(UserFacade.class);
    private final UserMapper userMapper;
    private final UserService userService;
    private final FileMapper fileMapper;
    private final FileService fileService;

    public UserFacade(UserMapper userMapper, UserService userService, FileMapper fileMapper, FileService fileService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.fileMapper = fileMapper;
        this.fileService = fileService;
    }

    public UserDto createUser(CreateUserRequest request, List<MultipartFile> files) {
        CustomUtilService.ValidateRequired(request.getNames());
        CustomUtilService.ValidateRequired(request.getEmail());

        userService.validateUserExists(request.getEmail());

        User user = User.builder()
                .names(request.getNames())
                .lastnames(request.getLastnames())
                .email(request.getEmail())
                .build();

        User userSaved = userService.save(user);

        createFiles(files, userSaved);

        return userMapper.toDto(userSaved);
    }

    public UserFilesResponse findUserWithFiles(String email) {
        CustomUtilService.ValidateRequired(email);

        User user = userService.findByEmail(email);
        List<File> files = fileService.findAllByUserId(user.getId());

        var urlBase = "urlBase/";

        List<FileDto> filesDto = files.stream()
                .map(fileMapper::toDto)
                .peek(fileDto -> fileDto.setUrl(urlBase.concat(fileDto.getFileName())))
                .collect(Collectors.toList());

        UserFilesResponse response = new UserFilesResponse();
        response.setUser(userMapper.toDto(user));
        response.setFiles(filesDto);
        return response;
    }

    private void createFiles(List<MultipartFile> files, User userSaved) {
        if (Objects.nonNull(files) && !files.isEmpty()) {
            files.forEach(fileRequest -> {
                String fileName = fileRequest.getOriginalFilename();
                Boolean fileExists = fileService.fileExists(fileName, userSaved.getId());
                if (fileExists) {
                    File fileFound = fileService.findByFileNameAndUserId(fileName, userSaved.getId());
                    fileService.update(fileFound);
                } else {
                    File file = File.builder()
                            .fileName(fileName)
                            .userId(userSaved.getId())
                            .build();
                    fileService.save(file);
                }
            });
        }
    }
}
