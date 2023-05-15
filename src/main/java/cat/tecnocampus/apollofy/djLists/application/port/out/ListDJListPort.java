package cat.tecnocampus.apollofy.djLists.application.port.out;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListEntity;
import cat.tecnocampus.apollofy.djLists.application.port.in.DJListListing;
import cat.tecnocampus.apollofy.djLists.application.port.in.DJListTrackFragmentListing;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;

import java.util.List;
import java.util.Optional;

public interface ListDJListPort {

    DJListEntity findById(Long playListId);
}
