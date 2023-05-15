package cat.tecnocampus.apollofy.djLists.application.service;

import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylist;
import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylistCommand;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListPlaylistPort;
import cat.tecnocampus.apollofy.djLists.application.port.out.StorePlaylistPort;
import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatePlaylistService implements CreatePlaylist {

    private final ListPlaylistPort listPlaylistPort;
    private final StorePlaylistPort storePlaylistPort;

    public CreatePlaylistService(ListPlaylistPort listPlaylistPort, StorePlaylistPort storePlaylistPort){
        this.listPlaylistPort=listPlaylistPort;
        this.storePlaylistPort=storePlaylistPort;
    }
    @Override
    public void createPlaylist(CreatePlaylistCommand createPlaylistCommand, String name){
        storePlaylistPort.storePlaylist(createPlaylistCommand,name);
    }
    @Override
    public void addTracksToPlayList(Long id, List<Long> trackIds){
        storePlaylistPort.addTracksToPlaylist(id,trackIds);
    }
}
