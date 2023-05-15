package cat.tecnocampus.apollofy.djLists.adapter.out.persistance;

import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;
import cat.tecnocampus.apollofy.djLists.domain.Playlist;
import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long>  {
    @Query("""
            select p from play_list p
            where p.owner.email =:email
            
            """)
    List<PlaylistEntity>  findAllPlaylistByEmail(@Param("email") String email);

}
