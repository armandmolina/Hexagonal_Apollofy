package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;

import java.util.List;

public interface ListPlaylist {
    List<PlaylistListing> getUserPlayLists(String name);

    List<PlaylistListing> getPlayLists();

    PlaylistListing getPlayListById(Long id);

}
