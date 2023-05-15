package cat.tecnocampus.apollofy.track.adapter.in.web;

import cat.tecnocampus.apollofy.track.application.port.in.CreateTrack;
import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StoreTracksController {
    private final CreateTrack createTrack;

    public StoreTracksController(CreateTrack createTrack) {
        this.createTrack = createTrack;
    }

    @PostMapping("/tracks") //OK
    public void storeTrack(@RequestBody CreateTrackCommand createTrackCommand) {
        createTrack.createTrack(createTrackCommand);
    }
}
