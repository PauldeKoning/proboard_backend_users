package nl.hu.minor.proboard_backend_users.service;

import nl.hu.minor.proboard_backend_users.model.Permission;
import nl.hu.minor.proboard_backend_users.model.User;
import nl.hu.minor.proboard_backend_users.model.exceptions.UserNotFoundException;
import nl.hu.minor.proboard_backend_users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> all() {
        ArrayList<User> users = new ArrayList<>();

        this.userRepository.findAll().forEach(users::add);

        return users;
    }

    public User one(Integer id) {
        var user = this.userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException();

        return user.get();
    }

    public User create(User user) {
        return this.userRepository.save(user);
    }

    public void delete(Integer id) {
        this.userRepository.delete(this.one(id));
    }
}
