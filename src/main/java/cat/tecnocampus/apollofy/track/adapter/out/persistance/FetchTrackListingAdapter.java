package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackEntityTrackListing;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FetchTrackListingAdapter implements ListTrackPort {
    TrackRepository trackRepository;

    public FetchTrackListingAdapter(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public TrackListing loadTrackById(Long Id) {
        return MapperTrackEntityTrackListing.trackEntityToTrackListing(trackRepository.findTrackById(Id).get());
    }

    @Override
    public List<TrackListing> loadAllTracks() {
        return MapperTrackEntityTrackListing.trackEntityListToTrackListingList(trackRepository.findAll());
    }

}
