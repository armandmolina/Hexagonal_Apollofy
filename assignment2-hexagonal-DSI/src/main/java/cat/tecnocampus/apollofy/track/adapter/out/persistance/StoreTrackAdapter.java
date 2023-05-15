package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.in.CreateTrackCommand;
import cat.tecnocampus.apollofy.track.application.port.out.StoreTrackPort;
import cat.tecnocampus.apollofy.track.domain.Track;
import org.springframework.stereotype.Component;

@Component
public class StoreTrackAdapter implements StoreTrackPort {
    private final TrackRepository trackRepository;

    public StoreTrackAdapter(TrackRepository profileRepository) {
        this.trackRepository = profileRepository;
    }

    @Override
    public void storeTrack(CreateTrackCommand createTrackCommand) {
        trackRepository.save(trackCommand2TrackEntity(createTrackCommand));
    }

    public void storeTrack(TrackEntity trackEntity){
        trackRepository.save(trackEntity);
    }
    private TrackEntity trackCommand2TrackEntity(CreateTrackCommand createTrackCommand) {
        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setTitle(createTrackCommand.title());
        trackEntity.setDurationSeconds(createTrackCommand.durationSeconds());

        return trackEntity;
    }

    private TrackEntity track2TrackEntity(Track track) {
        TrackEntity trackEntity = new TrackEntity();
        trackEntity.setTitle(track.getTitle());
        trackEntity.setDurationSeconds(track.getDurationSeconds());

        return trackEntity;
    }
}
