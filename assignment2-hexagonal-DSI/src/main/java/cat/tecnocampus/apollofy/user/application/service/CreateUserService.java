package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.application.port.in.CreateUser;
import cat.tecnocampus.apollofy.user.application.port.in.CreateUserCommand;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.port.out.StoreUserPort;
import cat.tecnocampus.apollofy.user.application.service.exception.UserAlreadyExists;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUser {
    private final ListUserPort listUserPort;
    private final StoreUserPort storeUserPort;
    
    public CreateUserService(ListUserPort listUserPort, StoreUserPort storeUserPort){
        this.listUserPort = listUserPort;
        this.storeUserPort = storeUserPort;
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand) throws Exception {
        if(listUserPort.loadUserByName(createUserCommand.name())!=null)throw new Exception("User already exists");
        storeUserPort.storeUser(createUserCommand);
    }
}
