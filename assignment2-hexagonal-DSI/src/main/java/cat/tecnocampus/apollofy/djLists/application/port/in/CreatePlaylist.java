package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.djLists.domain.Playlist;

import java.util.List;

public interface CreatePlaylist {
    void createPlaylist(CreatePlaylistCommand createPlaylistCommand, String name);

    void addTracksToPlayList(Long id, List<Long> trackIds);
}
