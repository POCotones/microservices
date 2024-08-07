package com.ritallus.ms_users.services;

import com.ritallus.ms_users.entities.File;
import com.ritallus.ms_users.exceptions.DataNotFoundException;
import com.ritallus.ms_users.repositories.FileRepository;
import com.ritallus.ms_users.utils.MessageResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class FileService {
    private final FileRepository repository;

    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public Boolean fileExists(String fileName, Long userId) {
        var file = repository.findByFileNameAndUserId(fileName, userId);
        return file.isPresent();
    }

    public File save(File file) {
        file.setCreateDate(LocalDateTime.now());
        file.setLastUpdate(LocalDateTime.now());
        return repository.save(file);
    }

    public File update(File file) {
        validateFile(file.getId());
        file.setLastUpdate(LocalDateTime.now());
        return repository.save(file);
    }

    public File findByFileNameAndUserId(String fileName, Long userId) {
        return repository.findByFileNameAndUserId(fileName, userId).orElseThrow(() ->
                new DataNotFoundException(MessageResponse.FILE_NOT_FOUND_EXCEPTION));
    }

    public void validateFile(Long id) {
        repository.findById(id).orElseThrow(() ->
                new DataNotFoundException(MessageResponse.FILE_NOT_FOUND_EXCEPTION));
    }

    public List<File> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }
}