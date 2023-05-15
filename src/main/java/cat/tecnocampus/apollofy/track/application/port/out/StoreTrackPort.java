package cat.tecnocampus.apollofy.track.application.port.out;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import cat.tecnocampus.apollofy.track.domain.Track;

public interface StoreTrackPort {
    void storeTrack(CreateTrackCommand createTrackCommand);
    void storeTrack(TrackEntity trackEntity);
}
