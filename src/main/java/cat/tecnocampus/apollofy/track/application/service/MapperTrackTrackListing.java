package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.domain.Track;

import java.util.ArrayList;
import java.util.List;

public class MapperTrackTrackListing {
    public static Track trackListingToTrack(TrackListing trackListing){
        Track track= new Track();
        track.setDurationSeconds(trackListing.durationSeconds());
        track.setTitle(trackListing.title());
        track.setGenres(MapperGenreGenreListing.GenreListingSetToGenreSet(trackListing.genreListings()));
        return track;

    }

    public static List<TrackListing> trackListToTrackListingList(List<Track> tracks){
        List<TrackListing> trackListings = new ArrayList<>();
        tracks.forEach(le -> trackListings.add(trackToTrackListing(le)));
        return trackListings;
    }
    public static TrackListing trackToTrackListing(Track track) {
        TrackListing trackListing =
                new TrackListing(track.getId(),track.getTitle(), track.getDurationSeconds(), MapperGenreGenreListing.GenreSetToGenreListingSet(track.getGenres()));
        return trackListing;
    }
}
