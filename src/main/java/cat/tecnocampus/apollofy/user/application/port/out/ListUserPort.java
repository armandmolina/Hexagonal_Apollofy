package cat.tecnocampus.apollofy.user.application.port.out;


import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.in.UserProjectionListing;

import java.util.List;
import java.util.Optional;

public interface ListUserPort {
    UserListing loadUserByName(String name);

    List<UserListing> loadAllUsers();

    UserListing findByName(String name);

    List<UserProjectionListing> getUserProjections();
}
