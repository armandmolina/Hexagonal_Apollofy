package cat.tecnocampus.apollofy.djLists.application.port.out;

import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;

import java.util.List;

public interface ListPlaylistPort {
    List<PlaylistListing> findUserPlayLists(String email);

    List<PlaylistListing> findAll();

    PlaylistListing findById(Long id);
}
