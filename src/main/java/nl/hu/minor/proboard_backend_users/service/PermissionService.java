package nl.hu.minor.proboard_backend_users.service;

import nl.hu.minor.proboard_backend_users.model.Permission;
import nl.hu.minor.proboard_backend_users.model.exceptions.PermissionAlreadyExistsException;
import nl.hu.minor.proboard_backend_users.model.exceptions.PermissionNotFoundException;
import nl.hu.minor.proboard_backend_users.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final UserService userService;

    public PermissionService(PermissionRepository permissionRepository, UserService userService) {
        this.permissionRepository = permissionRepository;
        this.userService = userService;
    }

    public List<Permission> all(Integer user) {
        return this.permissionRepository.findAllByUser(this.userService.one(user));
    }

    public Permission one(Integer userId, Integer permissionId) {
        var user = this.userService.one(userId);

        var permission = this.permissionRepository.findByObjectIdAndUser(permissionId, user);

        if (permission.isEmpty())
            throw new PermissionNotFoundException();

        return permission.get();
    }

    public Permission create(Integer userId, Permission permission) {
        var user = this.userService.one(userId);
        permission.setUser(user);

        var permissionRepo = this.permissionRepository.findByObjectIdAndUser(permission.getObjectId(), user);

        if(permissionRepo.isPresent())
            throw new PermissionAlreadyExistsException();

        return this.permissionRepository.save(permission);
    }

    public void delete(Integer user, Integer permission) {
        this.permissionRepository.delete(this.one(user, permission));
    }
}
