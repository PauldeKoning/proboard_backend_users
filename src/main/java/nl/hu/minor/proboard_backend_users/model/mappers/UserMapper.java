package nl.hu.minor.proboard_backend_users.model.mappers;

import nl.hu.minor.proboard_backend_users.model.Permission;
import nl.hu.minor.proboard_backend_users.model.PermissionDTO;
import nl.hu.minor.proboard_backend_users.model.User;
import nl.hu.minor.proboard_backend_users.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    @Mapping(target = "permissions", ignore = true)
    User toEntity(UserDTO user);

    List<UserDTO> toDTOList(List<User> users);
}
