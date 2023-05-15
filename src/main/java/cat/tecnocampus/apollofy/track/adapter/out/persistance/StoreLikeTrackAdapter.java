package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.out.StoreLikeTrackPort;
import cat.tecnocampus.apollofy.track.application.service.MapperTrackTrackEntity;
import cat.tecnocampus.apollofy.track.domain.LikeTrack;
import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreLikeTrackAdapter implements StoreLikeTrackPort {
    private final LikeTrackRepository likeTrackRepository;

    public StoreLikeTrackAdapter(LikeTrackRepository likeTrackRepository){this.likeTrackRepository=likeTrackRepository;}

    @Override
    public void storeLikeTrack(LikeTrack likeTrack) {
        likeTrackRepository.save(likeTrack2LikeTrackEntity(likeTrack));
    }

    private LikeTrackEntity likeTrack2LikeTrackEntity(LikeTrack likeTrack){
        LikeTrackEntity likeTrackEntity = new LikeTrackEntity();
        likeTrackEntity.setUserEntity(MapperUserFyUserEntity.userFyToUserEntity(likeTrack.getUserFy()));
        likeTrackEntity.setTrackEntity(MapperTrackTrackEntity.trackToTrackEntity(likeTrack.getTrack()));

        return likeTrackEntity;
    }
}
