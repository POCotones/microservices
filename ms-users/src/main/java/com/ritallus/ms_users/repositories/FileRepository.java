package com.ritallus.ms_users.repositories;

import com.ritallus.ms_users.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findByFileNameAndUserId(String fileName, Long userId);
    List<File> findAllByUserId(Long userId);
}
