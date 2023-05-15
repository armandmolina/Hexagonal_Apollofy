package cat.tecnocampus.apollofy.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CreateUser {
    void createUser(@Valid CreateUserCommand createUserCommand) throws Exception;
}