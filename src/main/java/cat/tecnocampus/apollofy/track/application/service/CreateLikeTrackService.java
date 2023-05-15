package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.application.port.in.CreateLikeTrack;
import cat.tecnocampus.apollofy.track.application.port.in.CreateLikeTrackCommand;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.application.port.out.StoreLikeTrackPort;
import cat.tecnocampus.apollofy.track.application.port.out.StoreTrackPort;
import cat.tecnocampus.apollofy.track.domain.LikeTrack;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.service.MapperUserUserListing;
import org.springframework.stereotype.Service;

@Service
public class CreateLikeTrackService implements CreateLikeTrack {
    private final ListTrackPort listTrackPort;
    private final ListUserPort listUserPort;
    private final StoreLikeTrackPort storeLikeTrackPort;

    public CreateLikeTrackService(ListTrackPort listTrackPort, ListUserPort listUserPort, StoreLikeTrackPort storeLikeTrackPort) {
        this.listTrackPort = listTrackPort;
        this.listUserPort = listUserPort;
        this.storeLikeTrackPort = storeLikeTrackPort;
    }

    @Override
    public void createLikeTrack(CreateLikeTrackCommand createLikeTrackCommand) {
        UserListing userListing = listUserPort.loadUserByName(createLikeTrackCommand.userName());
        TrackListing trackListing = listTrackPort.loadTrackById(createLikeTrackCommand.trackId());
        LikeTrack likeTrack = new LikeTrack(MapperUserUserListing.userListingToUser(userListing), MapperTrackTrackListing.trackListingToTrack(trackListing));


        storeLikeTrackPort.storeLikeTrack(likeTrack);
    }
}
