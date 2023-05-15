package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListPlaylistPort;
import cat.tecnocampus.apollofy.djLists.application.service.MapperPlaylistEntityPlaylistListing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchPlaylistListingAdapter implements ListPlaylistPort {
    PlaylistRepository playlistRepository;
    public FetchPlaylistListingAdapter(PlaylistRepository playlistRepository){
        this.playlistRepository=playlistRepository;
    }
    @Override
    public List<PlaylistListing> findUserPlayLists(String email){
        return MapperPlaylistEntityPlaylistListing.playlistEntityListToPlaylistListingList(playlistRepository.findAllPlaylistByEmail(email));
    }
    @Override
    public List<PlaylistListing> findAll(){
        return MapperPlaylistEntityPlaylistListing.playlistEntityListToPlaylistListingList(playlistRepository.findAll());
    }
    public PlaylistListing findById(Long id){
        return MapperPlaylistEntityPlaylistListing.playlistEntityToPlaylistListing(playlistRepository.findById(id).get());
    }
}
