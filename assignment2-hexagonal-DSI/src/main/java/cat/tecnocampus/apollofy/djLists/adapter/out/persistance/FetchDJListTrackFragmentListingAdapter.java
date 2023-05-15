package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.out.ListDJListTrackFragmentPort;
import cat.tecnocampus.apollofy.djLists.application.service.MapperDjListDjListEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackEntity;
import cat.tecnocampus.apollofy.track.domain.Track;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FetchDJListTrackFragmentListingAdapter implements ListDJListTrackFragmentPort {
    private final DJListTrackFragmentRepository djListTrackFragmentRepository;
    public FetchDJListTrackFragmentListingAdapter(DJListTrackFragmentRepository djListTrackFragmentRepository){
        this.djListTrackFragmentRepository=djListTrackFragmentRepository;
    }
    @Override
    public Optional<DJListTrackFragmentEntity> findByTrackEntityAndDjListEntity(Track track, DJList djList) {

        TrackEntity trackEntity =  MapperTrackTrackEntity.trackToTrackEntity(track);
        DJListEntity djListEntity = MapperDjListDjListEntity.djListToDJListEntity(djList);

        return djListTrackFragmentRepository.findByTrackEntityAndDjListEntity(trackEntity, djListEntity);
    }


}
