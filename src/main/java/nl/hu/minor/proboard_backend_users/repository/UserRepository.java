package nl.hu.minor.proboard_backend_users.repository;

import nl.hu.minor.proboard_backend_users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
