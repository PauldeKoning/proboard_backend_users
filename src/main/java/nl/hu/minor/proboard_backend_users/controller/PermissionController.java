package nl.hu.minor.proboard_backend_users.controller;

import nl.hu.minor.proboard_backend_users.model.PermissionDTO;
import nl.hu.minor.proboard_backend_users.model.mappers.PermissionMapper;
import nl.hu.minor.proboard_backend_users.service.PermissionService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PermissionController {
    private final PermissionService permissionService;
    private final PermissionMapper permissionMapper;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
        this.permissionMapper = Mappers.getMapper(PermissionMapper.class);
    }

    @GetMapping("/permissions/{user}")
    public List<PermissionDTO> all(@PathVariable(value = "user") Integer user) {
        return this.permissionMapper.toDTOList(this.permissionService.all(user));
    }

    @GetMapping("/permission/{user}/{permission}")
    public PermissionDTO one(@PathVariable(value = "user") Integer user,
                             @PathVariable(value = "permission") Integer permission) {
        return this.permissionMapper.toDTO(this.permissionService.one(user, permission));
    }

    @PostMapping("/permission/{user}")
    public PermissionDTO create(@PathVariable(value = "user") Integer user,
                                @Valid @RequestBody PermissionDTO permission) {
        var createdPermission = this.permissionService.create(user, this.permissionMapper.toEntity(permission));
        return this.permissionMapper.toDTO(createdPermission);
    }

    @DeleteMapping("/permission/{user}/{permission}")
    public void delete(@PathVariable(value = "user") Integer user,
                       @PathVariable(value = "permission") Integer permission) {
        this.permissionService.delete(user, permission);
    }
}
