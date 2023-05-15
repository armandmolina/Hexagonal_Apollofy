package cat.tecnocampus.apollofy.djLists.application.port.in;

import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.track.domain.Track;


public record DJListTrackFragmentListing(Long trackId, Long startTimeMillis, Long endTimeMillis, Track track, DJList djList) {
    public DJListTrackFragmentListing(Long trackId, Long startTimeMillis, Long endTimeMillis){
        this(trackId,startTimeMillis,endTimeMillis,null,null);
    }
}
