package com.ritallus.ms_users.mappers;

import com.ritallus.ms_users.dto.UserDto;
import com.ritallus.ms_users.entities.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UserMapper extends EntityMapper<UserDto, User> {

}
