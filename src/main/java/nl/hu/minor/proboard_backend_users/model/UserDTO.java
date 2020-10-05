package nl.hu.minor.proboard_backend_users.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
