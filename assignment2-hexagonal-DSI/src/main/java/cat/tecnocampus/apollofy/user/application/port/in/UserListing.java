package cat.tecnocampus.apollofy.user.application.port.in;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.domain.Track;

import java.util.List;

public record UserListing(Long id, String name, String secondName, String password, String email,List<TrackListing> authorizedTrackListings) {

}
