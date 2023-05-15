package cat.tecnocampus.apollofy.djLists.adapter.in.web;

import cat.tecnocampus.apollofy.djLists.application.port.in.ListPlaylist;
import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;
import cat.tecnocampus.apollofy.djLists.application.service.MapperPlaylistEntityPlaylistListing;
import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
public class ListPlaylistController {
    private final ListPlaylist listPlaylist;

    ListPlaylistController(ListPlaylist listPlaylist){
        this.listPlaylist=listPlaylist;
    }

    @GetMapping("/api/me/playLists")    //OK
    public List<PlaylistListing> getUserPlayLists(Principal principal) {
        return listPlaylist.getUserPlayLists(principal.getName());
    }

    @GetMapping("/playLists")   //OK
    public List<PlaylistListing> getPlayLists() {
        return listPlaylist.getPlayLists();
    }

    @GetMapping("/playLists/{id}")  //OK
    public PlaylistListing getPlayList(@PathVariable Long id) {
        return listPlaylist.getPlayListById(id);
    }
    
}
