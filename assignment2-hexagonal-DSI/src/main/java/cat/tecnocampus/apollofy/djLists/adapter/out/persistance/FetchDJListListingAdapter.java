package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.in.DJListListing;
import cat.tecnocampus.apollofy.djLists.application.port.in.DJListTrackFragmentListing;
import cat.tecnocampus.apollofy.djLists.application.port.out.ListDJListPort;
import cat.tecnocampus.apollofy.djLists.application.service.MapperDjListDjListEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FetchDJListListingAdapter implements ListDJListPort {

    private final DJListRepository djListRepository;
    public FetchDJListListingAdapter (DJListRepository djListRepository){
        this.djListRepository=djListRepository;
    }
    @Override
    public DJListEntity findById(Long playListId){
        return djListRepository.findById(playListId).get();
    }

}
