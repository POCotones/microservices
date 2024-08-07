package com.ritallus.ms_files.facades;


import com.ritallus.ms_files.mappers.FileMapper;
import com.ritallus.ms_files.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FileFacade {
    private final Logger log = LoggerFactory.getLogger(FileFacade.class);

    private final FileMapper fileMapper;
    private final FileService fileService;


    public FileFacade(FileMapper fileMapper, FileService fileService) {
        this.fileMapper = fileMapper;
        this.fileService = fileService;
    }
}
