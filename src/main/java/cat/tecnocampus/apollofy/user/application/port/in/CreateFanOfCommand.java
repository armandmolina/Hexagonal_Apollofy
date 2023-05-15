package cat.tecnocampus.apollofy.user.application.port.in;

import javax.validation.constraints.NotNull;

public record CreateFanOfCommand(
        @NotNull (message = "User can't be null")
        String userName1,
        @NotNull (message = "User can't be null")
        String userName2) {
}
