package cat.tecnocampus.apollofy.djLists.application.service;



import cat.tecnocampus.apollofy.djLists.application.port.in.ListPlaylist;
import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListPlaylistPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPlaylistService implements ListPlaylist {
    private final ListPlaylistPort listPlaylistPort;

    ListPlaylistService(ListPlaylistPort listPlaylistPort){
        this.listPlaylistPort=listPlaylistPort;
    }
    @Override
    public List<PlaylistListing> getUserPlayLists(String name){
        return listPlaylistPort.findUserPlayLists(name);
    }
    @Override
    public List<PlaylistListing> getPlayLists(){
        return listPlaylistPort.findAll();
    }
    @Override
    public PlaylistListing getPlayListById(Long id){
        return listPlaylistPort.findById(id);
    }


}
