package cat.tecnocampus.apollofy.track.application.port.out;

import cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface ListLikeTrackPort {
    List<TrackListing> loadLikeTracksByUser(String name);

    List<PopularTrackListing> popularTracks(LocalDateTime from, LocalDateTime to, Pageable pageable);


}
