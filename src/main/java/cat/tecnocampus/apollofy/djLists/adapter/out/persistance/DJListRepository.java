package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.domain.DJListTrackFragment;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DJListRepository extends JpaRepository<DJListEntity, Long> {


}
