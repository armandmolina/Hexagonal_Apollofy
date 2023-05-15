package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrackRepository extends JpaRepository<TrackEntity, Long> {

    Optional<TrackEntity> findTrackById(Long id);

}
