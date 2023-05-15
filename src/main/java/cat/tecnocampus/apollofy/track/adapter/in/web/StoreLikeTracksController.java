package cat.tecnocampus.apollofy.track.adapter.in.web;

import cat.tecnocampus.apollofy.track.application.port.in.CreateLikeTrack;
import cat.tecnocampus.apollofy.track.application.port.in.CreateLikeTrackCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreLikeTracksController {
    private final CreateLikeTrack createLikeTrack;

    public StoreLikeTracksController(CreateLikeTrack createLikeTrack){
        this.createLikeTrack=createLikeTrack;
    }
    @PostMapping("/likeTracks")
    public void storeLikeTrack(@RequestBody CreateLikeTrackCommand createLikeTrackCommand){
        createLikeTrack.createLikeTrack(createLikeTrackCommand);
    }

}
