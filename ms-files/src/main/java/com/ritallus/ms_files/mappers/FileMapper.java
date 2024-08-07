package com.ritallus.ms_files.mappers;

import com.ritallus.ms_files.dto.FileDto;
import com.ritallus.ms_files.entities.File;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface FileMapper extends EntityMapper<FileDto, File> {

}
