package cat.tecnocampus.apollofy.djLists.application.service;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListTrackFragmentEntity;
import cat.tecnocampus.apollofy.djLists.application.port.in.DJListTrackFragmentListing;
import cat.tecnocampus.apollofy.djLists.application.port.in.ListDJList;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListDJListPort;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListDJListTrackFragmentPort;
import cat.tecnocampus.apollofy.djLists.application.port.out.StoreDJListTrackFragmentPort;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.djLists.domain.DJListTrackFragment;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackListing;
import cat.tecnocampus.apollofy.track.domain.Track;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.service.MapperUserUserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListDJListService implements ListDJList {

    private final ListDJListPort listDJListPort;
    private final StoreDJListTrackFragmentPort storeDJListTrackFragmentPort;
    private final ListDJListTrackFragmentPort listDJListTrackFragmentPort;
    private final ListTrackPort listTrackPort;
    private final ListUserPort listUserPort;

    public ListDJListService(ListDJListPort listDJListPort, StoreDJListTrackFragmentPort storeDJListTrackFragmentPort, ListDJListTrackFragmentPort listDJListTrackFragmentPort, ListTrackPort listTrackPort, ListUserPort listUserPort){
        this.listDJListPort=listDJListPort;
        this.storeDJListTrackFragmentPort = storeDJListTrackFragmentPort;
        this.listDJListTrackFragmentPort = listDJListTrackFragmentPort;
        this.listTrackPort = listTrackPort;
        this.listUserPort = listUserPort;
    }

    public void addTracksToPlaylistWithTimeRange(String name, Long playListId, List<DJListTrackFragmentListing> djListTrackFragmentListingList){
        DJList djList =MapperDjListDjListEntity.djListEntityToDJList(listDJListPort.findById(playListId));
        UserFy userFy = MapperUserUserListing.userListingToUser(listUserPort.loadUserByName(name));

        if(!djList.getOwner().equals(userFy)){
            throw new RuntimeException("You are not the playlist owner.");
        }

        for (DJListTrackFragmentListing djListTrackFragmentListing : djListTrackFragmentListingList) {
            Track track = MapperTrackTrackListing.trackListingToTrack(listTrackPort.loadTrackById(djListTrackFragmentListing.trackId()));
            addTrackToPlaylist(djList, djListTrackFragmentListing, track);

        }

    }
    private void addTrackToPlaylist(DJList djList, DJListTrackFragmentListing djListTrackFragmentListing, Track track) {
        Optional<DJListTrackFragmentEntity> playlistTrackOptional = listDJListTrackFragmentPort.findByTrackEntityAndDjListEntity(track, djList);

        if (playlistTrackOptional.isPresent()) {
            DJListTrackFragment djListTrackFragment = MapperDjListTrackFragmentEntityToDjListTrackFragment.djListTrackFragmentEntityToDjListTrackFragment(playlistTrackOptional.get());

            djListTrackFragment.setStartTimeMillis(djListTrackFragmentListing.startTimeMillis());
            djListTrackFragment.setEndTimeMillis(djListTrackFragmentListing.endTimeMillis());

        } else {

            DJListTrackFragment dJListTrackFragment = new DJListTrackFragment(djListTrackFragmentListing.startTimeMillis(),
                    djListTrackFragmentListing.endTimeMillis(),
                    track,
                    djList);
            storeDJListTrackFragmentPort.storeDJListTrackFragment(dJListTrackFragment);
        }
    }
}
