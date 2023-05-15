package cat.tecnocampus.apollofy.djLists.adapter.in.web;

import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylist;
import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylistCommand;
import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
public class StorePlaylistController {
    private final CreatePlaylist createPlayList;

    public StorePlaylistController(CreatePlaylist createPlayList){
        this.createPlayList=createPlayList;
    }
    @PostMapping("/api/me/playLists")
    public void postPlayLists(@RequestBody CreatePlaylistCommand CreatePlayListCommand, Principal principal) {
       createPlayList.createPlaylist(CreatePlayListCommand, principal.getName());
    }
    @PutMapping("/playLists/{id}/tracks")
    public void addTracksToPlayList(@PathVariable Long id, @RequestBody List<Long> trackIds) {
        createPlayList.addTracksToPlayList(id, trackIds);
    }


}
