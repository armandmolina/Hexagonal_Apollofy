package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.in.CreatePlaylistCommand;
import cat.tecnocampus.apollofy.djLists.application.port.out.StorePlaylistPort;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackRepository;
import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorePlaylistAdapter implements StorePlaylistPort {

    private final PlaylistRepository playlistRepository;
    private final TrackRepository trackRepository;

    public StorePlaylistAdapter(PlaylistRepository playlistRepository, TrackRepository trackRepository){
        this.playlistRepository=playlistRepository;
        this.trackRepository=trackRepository;
    }
    @Override
    public void storePlaylist(CreatePlaylistCommand createPlaylistCommand, String name){
        playlistRepository.save(playlistCommand2PlaylistEntity(createPlaylistCommand));
    }
    private PlaylistEntity playlistCommand2PlaylistEntity(CreatePlaylistCommand createPlaylistCommand) {
        PlaylistEntity playlistEntity= new PlaylistEntity();
        playlistEntity.setId(createPlaylistCommand.id());
        playlistEntity.setDescription(createPlaylistCommand.description());
        playlistEntity.setOpen(createPlaylistCommand.open());
        playlistEntity.setTitle(createPlaylistCommand.title());
        playlistEntity.setTracks(createPlaylistCommand.trackEntities());
        return playlistEntity;
    }
    public void addTracksToPlaylist(Long id, List<Long> trackIds){
       PlaylistEntity playlistEntity= playlistRepository.findById(id).get();
       for(Long IDS:trackIds){
           TrackEntity trackEntity=trackRepository.findTrackById(IDS).get();
           playlistEntity.addTrack(trackEntity);
       }
    }

}
