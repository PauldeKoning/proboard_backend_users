package nl.hu.minor.proboard_backend_users.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PermissionAlreadyExistsException extends RuntimeException {
}
