package cat.tecnocampus.apollofy.track.adapter.out.persistance;

import cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface LikeTrackRepository extends JpaRepository<LikeTrackEntity, Long>{

    @Query("select new cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing(track.id, track.title, count(track)) " +
            "from like_track lt inner join lt.trackEntity track where lt.liked = TRUE and lt.date >= :from and lt.date <= :to" +
            " group by track.id order by count(track) desc ")

    List<PopularTrackListing> popularTracks(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to, Pageable pageable);

    @Query("""
        select t.trackEntity
        from like_track t
        where t.userEntity.name =:name
    """)
    List<TrackEntity> findByUserEntityName(@Param("name") String name);
}
