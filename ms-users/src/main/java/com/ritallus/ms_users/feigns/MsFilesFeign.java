package com.ritallus.ms_users.feigns;


import com.ritallus.ms_users.configs.MsFilesFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "ms-files", url = "${ms-files.url}", configuration = MsFilesFeignConfiguration.class)
public interface MsFilesFeign {

    @PostMapping("")
    StandardResponse<BlockDTO> saveBlock(@RequestBody BlockDTO blockDTO, @RequestHeader("Authorization") String token);


}
