package cat.tecnocampus.apollofy.track.application.port.in;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface ListTracks {
    List<TrackListing> getAllTracks();

    TrackListing getTrackById(Long id);

    void addGenresToTrack(Long id, List<Long> genresId);

    void addArtistsToTrack(Long trackId, Set<String> artistsEmail);

    void removeGenreFromTrack(Long trackId, Long genreId);


}
