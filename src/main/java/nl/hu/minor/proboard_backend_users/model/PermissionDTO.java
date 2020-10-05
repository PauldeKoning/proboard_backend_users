package nl.hu.minor.proboard_backend_users.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PermissionDTO {

    @NotNull
    private Integer objectId;

    @NotNull
    private PermissionType type;

}
