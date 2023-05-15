package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.application.port.in.CreateTrack;
import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.application.port.out.StoreTrackPort;
import cat.tecnocampus.apollofy.track.application.service.exception.TrackAlreadyExists;
import org.springframework.stereotype.Service;

@Service
public class CreateTrackService implements CreateTrack {
    private final StoreTrackPort storeTrackPort;
    
    public CreateTrackService(StoreTrackPort storeTrackPort){
        this.storeTrackPort = storeTrackPort;
    }

    @Override
    public void createTrack(CreateTrackCommand createTrackCommand) {
        storeTrackPort.storeTrack(createTrackCommand);
    }
}
