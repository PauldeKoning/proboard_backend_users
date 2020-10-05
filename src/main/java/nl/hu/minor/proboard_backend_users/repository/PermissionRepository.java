package nl.hu.minor.proboard_backend_users.repository;

import nl.hu.minor.proboard_backend_users.model.Permission;
import nl.hu.minor.proboard_backend_users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
    Optional<Permission> findByObjectIdAndUser(Integer objectId, User user);

    List<Permission> findAllByUser(User user);
}
