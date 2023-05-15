package cat.tecnocampus.apollofy.track.application.port.out;

import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;

import java.util.List;
import java.util.Optional;

public interface ListTrackPort {
    TrackListing loadTrackById(Long id);

    List<TrackListing> loadAllTracks();


}
