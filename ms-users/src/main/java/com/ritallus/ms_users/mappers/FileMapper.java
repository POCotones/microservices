package com.ritallus.ms_users.mappers;

import com.ritallus.ms_users.dto.FileDto;
import com.ritallus.ms_users.entities.File;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {UserMapper.class})
public interface FileMapper extends EntityMapper<FileDto, File> {

    @AfterMapping
    default void removeUser(File file, @MappingTarget FileDto fileDto) {
        fileDto.setUser(null);
    }
}
