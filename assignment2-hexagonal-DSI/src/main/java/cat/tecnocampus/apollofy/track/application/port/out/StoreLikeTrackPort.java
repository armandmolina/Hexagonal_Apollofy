package cat.tecnocampus.apollofy.track.application.port.out;

import cat.tecnocampus.apollofy.track.application.port.in.CreateLikeTrackCommand;
import cat.tecnocampus.apollofy.track.domain.LikeTrack;

public interface StoreLikeTrackPort {
    void storeLikeTrack(LikeTrack LikeTrack);
}
