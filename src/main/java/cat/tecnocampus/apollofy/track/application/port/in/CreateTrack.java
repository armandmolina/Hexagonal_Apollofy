package cat.tecnocampus.apollofy.track.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

public interface CreateTrack {
    void createTrack(CreateTrackCommand createTrackCommand);
}