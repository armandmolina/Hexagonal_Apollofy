package cat.tecnocampus.apollofy.djLists.application.service;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListTrackFragmentEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJListTrackFragment;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackEntity;

public class MapperDjListTrackFragmentEntityToDjListTrackFragment {

    public static DJListTrackFragment djListTrackFragmentEntityToDjListTrackFragment(DJListTrackFragmentEntity djListTrackFragmentEntity){
        DJListTrackFragment djListTrackFragment= new DJListTrackFragment(djListTrackFragmentEntity.getStartTimeMillis(),djListTrackFragmentEntity.getEndTimeMillis(), MapperTrackTrackEntity.trackEntityToTrack(djListTrackFragmentEntity.getTrackEntity()),MapperDjListDjListEntity.djListEntityToDJList(djListTrackFragmentEntity.getPlaylistEntity()));

        return djListTrackFragment;
    }
}
