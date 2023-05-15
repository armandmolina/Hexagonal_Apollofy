package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.application.port.in.ListUsers;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.in.UserProjectionListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsersService implements ListUsers {

    private final ListUserPort listUserPort;

    ListUsersService(ListUserPort listUserPort){this.listUserPort=listUserPort;}
    
    @Override
    public List<UserListing> getUsers() {
        return listUserPort.loadAllUsers();
    }

    @Override
    public UserListing getMe(String name) {
        return listUserPort.findByName(name);
    }

    @Override
    public UserListing getUserByEmail(String email) {
        return null;
    }
    @Override
    public List<UserProjectionListing> getUserProjections(){
        return listUserPort.getUserProjections();
    }

}
