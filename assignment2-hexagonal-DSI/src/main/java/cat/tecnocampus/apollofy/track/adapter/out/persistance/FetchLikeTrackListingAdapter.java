package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.in.LikeTrackListing;
import cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListLikeTrackPort;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackEntityTrackListing;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackListing;
import cat.tecnocampus.apollofy.user.adapter.out.persistance.UserEntity;
import org.springframework.stereotype.Component;


import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class FetchLikeTrackListingAdapter implements ListLikeTrackPort {
    LikeTrackRepository likeTrackRepository;

    public FetchLikeTrackListingAdapter(LikeTrackRepository likeTrackRepository) {
        this.likeTrackRepository = likeTrackRepository;
    }

    @Override
    public List<TrackListing> loadLikeTracksByUser(String name) {
        return MapperTrackEntityTrackListing.trackEntityListToTrackListingList(likeTrackRepository.findByUserEntityName(name));
    }

    @Override
    public List<PopularTrackListing> popularTracks(LocalDateTime from, LocalDateTime to, Pageable pageable) {
        return likeTrackRepository.popularTracks(from,to, pageable);
    }
}
