package cat.tecnocampus.apollofy.user.adapter.in.web;

import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.domain.Track;
import cat.tecnocampus.apollofy.user.application.port.in.ListUsers;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.in.UserProjectionListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ListUsersController {
    private final ListUsers listUsers;

    public ListUsersController(ListUsers listUsers) {
        this.listUsers = listUsers;
    }

    @GetMapping("/users")   //OK
    public List<UserListing> getUsers() {
        return listUsers.getUsers();
    }

    @GetMapping("/api/me")  //OK
    public UserListing getUserMe(Principal principal) {
        return listUsers.getMe(principal.getName());
    }

    @GetMapping("/api/me/trackEntities")    //OK
    public List<TrackListing> getUserTracks(Principal principal) {
        return listUsers.getMe(principal.getName()).authorizedTrackListings();
    }

    @GetMapping("/userProjection")  //OK
    public List<UserProjectionListing> getUserProjections() {
        return listUsers.getUserProjections();
    }

}