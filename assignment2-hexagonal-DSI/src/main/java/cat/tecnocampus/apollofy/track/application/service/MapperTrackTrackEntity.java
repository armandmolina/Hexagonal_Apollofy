package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.domain.Track;

import java.util.ArrayList;
import java.util.List;

public class MapperTrackTrackEntity {
    public static TrackEntity trackToTrackEntity(Track track) {
        TrackEntity trackEntity= new TrackEntity();

        trackEntity.setTitle(track.getTitle());
        trackEntity.setDurationSeconds(track.getDurationSeconds());
        trackEntity.setGenres(MapperGenreGenreEntity.GenreSetToGenreEntitySet(track.getGenres()));
        return trackEntity;
    }

    public static List<Track> trackEntityListToTrackList(List<TrackEntity> trackEntities){
        List<Track> tracks = new ArrayList<>();
        trackEntities.forEach(le -> tracks.add(trackEntityToTrack(le)));
        return tracks;
    }

    public static Track trackEntityToTrack(TrackEntity trackEntity) {
        Track track= new Track();

        track.setTitle(trackEntity.getTitle());
        track.setDurationSeconds(trackEntity.getDurationSeconds());
        track.setGenres(MapperGenreGenreEntity.GenreEntitySetToGenreSet(trackEntity.getGenres()));
        return track;
    }
}
