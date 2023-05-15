package cat.tecnocampus.apollofy.user.application.port.out;

import cat.tecnocampus.apollofy.user.application.port.in.CreateUserCommand;

public interface StoreUserPort {
    public void storeUser(CreateUserCommand createUserCommand);
}
