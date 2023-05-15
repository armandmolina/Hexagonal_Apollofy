package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.out.StoreDJListTrackFragmentPort;
import cat.tecnocampus.apollofy.djLists.application.service.MapperDjListDjListEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJListTrackFragment;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreDJListTrackFragmentAdapter implements StoreDJListTrackFragmentPort {

    public DJListTrackFragmentRepository djListTrackFragmentRepository;

    public StoreDJListTrackFragmentAdapter(DJListTrackFragmentRepository djListTrackFragmentRepository){
        this.djListTrackFragmentRepository = djListTrackFragmentRepository;
    }

    public void storeDJListTrackFragment(DJListTrackFragment djListTrackFragment){
        djListTrackFragmentRepository.save(djListTrackFragment2DJListTrackFragmentEntity(djListTrackFragment));
    }

    private DJListTrackFragmentEntity djListTrackFragment2DJListTrackFragmentEntity(DJListTrackFragment djListTrackFragment) {
        DJListTrackFragmentEntity djListTrackFragmentEntity= new DJListTrackFragmentEntity();

        djListTrackFragmentEntity.setId(djListTrackFragment.getId());
        djListTrackFragmentEntity.setTrackEntity(MapperTrackTrackEntity.trackToTrackEntity(djListTrackFragment.getTrack()));
        djListTrackFragmentEntity.setPlaylistEntity(MapperDjListDjListEntity.djListToDJListEntity(djListTrackFragment.getPlaylist()));
        djListTrackFragmentEntity.setEndTimeMillis(djListTrackFragment.getEndTimeMillis());
        djListTrackFragmentEntity.setStartTimeMillis(djListTrackFragment.getStartTimeMillis());

        return djListTrackFragmentEntity;
    }

}
