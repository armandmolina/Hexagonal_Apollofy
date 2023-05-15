package cat.tecnocampus.apollofy.user.application.port.in;



import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import cat.tecnocampus.apollofy.user.domain.UserFy;

import java.util.List;

//FUNCIONES DEL CONTROLLER adapter.in.web ListTracksController
public interface ListUsers {
    List<UserListing> getUsers();
    UserListing getMe(String name);

    UserListing getUserByEmail(String email);

    List<UserProjectionListing> getUserProjections();
}
