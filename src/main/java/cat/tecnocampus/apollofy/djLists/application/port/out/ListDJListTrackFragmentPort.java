package cat.tecnocampus.apollofy.djLists.application.port.out;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListEntity;
import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListTrackFragmentEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.djLists.domain.DJListTrackFragment;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.domain.Track;

import java.util.Optional;
//storedjlisttrackfragmentadapter
public interface ListDJListTrackFragmentPort {
    Optional<DJListTrackFragmentEntity> findByTrackEntityAndDjListEntity(Track track, DJList djList);
}
