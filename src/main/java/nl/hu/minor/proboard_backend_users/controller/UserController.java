package nl.hu.minor.proboard_backend_users.controller;

import nl.hu.minor.proboard_backend_users.model.UserDTO;
import nl.hu.minor.proboard_backend_users.model.mappers.UserMapper;
import nl.hu.minor.proboard_backend_users.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    @GetMapping("/users")
    public List<UserDTO> all() {
        return this.userMapper.toDTOList(this.userService.all());
    }

    @GetMapping("/user/{id}")
    public UserDTO one(@PathVariable(value = "id") Integer id) {
        return this.userMapper.toDTO(this.userService.one(id));
    }

    @PostMapping("/user")
    public UserDTO create(@Valid @RequestBody UserDTO user) {
        return this.userMapper.toDTO(this.userService.create(this.userMapper.toEntity(user)));
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        this.userService.delete(id);
    }
}
