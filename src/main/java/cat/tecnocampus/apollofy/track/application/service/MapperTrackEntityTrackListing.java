package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;

import java.util.ArrayList;
import java.util.List;

public class MapperTrackEntityTrackListing {

    public static TrackListing trackEntityToTrackListing(TrackEntity trackEntity) {
        TrackListing trackListing =
                new TrackListing(trackEntity.getId(),trackEntity.getTitle(), trackEntity.getDurationSeconds(),MapperGenreEntityToListing.genreEntitySetToGenreListingSet(trackEntity.getGenres()));
        return trackListing;
    }

    public static List<TrackListing> trackEntityListToTrackListingList(List<TrackEntity> trackEntities){
        List<TrackListing> trackListings = new ArrayList<>();
        trackEntities.forEach(le -> trackListings.add(trackEntityToTrackListing(le)));
        return trackListings;
    }
    public static TrackEntity trackListingToTrackEntity(TrackListing trackListing){
        TrackEntity trackEntity= new TrackEntity();
        trackEntity.setTitle(trackListing.title());
        trackEntity.setGenres(MapperGenreEntityToListing.genreListingSetToGenreEntitySet(trackListing.genreListings()));
        trackEntity.setDurationSeconds(trackListing.durationSeconds());
        return trackEntity;
    }

}
