package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DJListTrackFragmentRepository extends JpaRepository<DJListTrackFragmentEntity, Long> {
    Optional<DJListTrackFragmentEntity> findByTrackEntityAndDjListEntity(TrackEntity trackEntity, DJListEntity djListEntity);

}
