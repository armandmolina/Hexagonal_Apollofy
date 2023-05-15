package cat.tecnocampus.apollofy.track.application.port.in;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;

import java.time.LocalDateTime;
import java.util.List;
//FUNCIONES DEL CONTROLLER adapter.in.web ListLikeTracksController
public interface ListLikeTrack {

    List<TrackListing> getUserLikedTracks(String name);

    List<PopularTrackListing> getPopularTracks(int size, LocalDateTime atStartOfDay, LocalDateTime atStartOfDay1);

}
