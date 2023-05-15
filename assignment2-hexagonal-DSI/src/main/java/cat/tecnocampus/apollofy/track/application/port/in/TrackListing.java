package cat.tecnocampus.apollofy.track.application.port.in;


import java.util.Set;

public record TrackListing(Long id, String title, Long durationSeconds, Set<GenreListing> genreListings) {
}
