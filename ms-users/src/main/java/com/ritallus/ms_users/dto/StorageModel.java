package com.ritallus.ms_users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StorageModel implements Serializable {

    private static final long serialVersionUID = 5177305459964144139L;

    @NotEmpty(message = "{NotEmpty.document.pathOrId}")
    private String path;

    @NotEmpty(message = "{NotEmpty.document.name}")
    private String name;

    private String owner;
    private LocalDateTime creationDate;
    private String mimeType;
    private String version;
    private Long contentStreamLength;

}
