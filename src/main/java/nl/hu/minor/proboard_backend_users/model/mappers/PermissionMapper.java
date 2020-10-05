package nl.hu.minor.proboard_backend_users.model.mappers;

import nl.hu.minor.proboard_backend_users.model.Permission;
import nl.hu.minor.proboard_backend_users.model.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionDTO toDTO(Permission permission);

    @Mapping(target = "user ", ignore = true)
    Permission toEntity(PermissionDTO permission);

    List<PermissionDTO> toDTOList(List<Permission> permissions);
}
