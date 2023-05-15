package cat.tecnocampus.apollofy.djLists.application.port.out;

import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylistCommand;

import java.util.List;

public interface StorePlaylistPort {
    void storePlaylist(CreatePlaylistCommand createPlaylistCommand, String name);

    void addTracksToPlaylist(Long id, List<Long> trackIds);
}
