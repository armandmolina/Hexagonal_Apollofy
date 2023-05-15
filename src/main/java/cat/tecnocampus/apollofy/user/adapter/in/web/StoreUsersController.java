package cat.tecnocampus.apollofy.user.adapter.in.web;

import cat.tecnocampus.apollofy.user.application.port.in.CreateUser;
import cat.tecnocampus.apollofy.user.application.port.in.CreateUserCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreUsersController {
    private final CreateUser createUser;

    public StoreUsersController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping("/users")  //OK
    public void storeUser(@RequestBody CreateUserCommand createUserCommand) throws Exception {
        createUser.createUser(createUserCommand);
    }

}
