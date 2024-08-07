package com.ritallus.ms_files.repositories;


import com.ritallus.ms_files.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
