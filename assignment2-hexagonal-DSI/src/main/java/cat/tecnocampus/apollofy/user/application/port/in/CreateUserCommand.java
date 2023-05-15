package cat.tecnocampus.apollofy.user.application.port.in;

import cat.tecnocampus.apollofy.user.domain.UserFy;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record CreateUserCommand(
        @NotNull (message = "Email can't be null")
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid email format")
        String email,
        @NotNull (message = "Name can't be null")
        String name,
        @NotNull (message = "Password can't be null")
        String password,
        String secondName


        ) {
}
