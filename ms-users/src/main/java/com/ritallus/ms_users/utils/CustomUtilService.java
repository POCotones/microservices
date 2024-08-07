package com.ritallus.ms_users.utils;


import com.ritallus.ms_users.dto.StorageModel;
import com.ritallus.ms_users.exceptions.RequiredException;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomUtilService {

    public static void ValidateRequired(Object object) {
        if (Objects.isNull(object)) {
            throw new RequiredException(MessageResponse.MISSING_REQUIRED_FIELD);
        }
    }

    public static void ValidateBooleanRequired(Object object) {
        if (!(object instanceof Boolean)) {
            throw new RequiredException(MessageResponse.MISSING_REQUIRED_FIELD);
        }
    }

    public StorageModel toStorageModel(MultipartFile file) {
        return StorageModel.builder()
                .name(file.getOriginalFilename())
                .contentStreamLength(file.getSize())
                .creationDate(LocalDateTime.now())
                .mimeType(file.getContentType())
                .build();
    }
}
