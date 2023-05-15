package cat.tecnocampus.apollofy.track.adapter.out.persistance;


import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.PopularGenreListing;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity,Long> {
    @Query("""
            select new cat.tecnocampus.apollofy.track.application.port.in.GenreListing(g.id,g.name)
            from genre g
            where g.id = :id
            """)
    GenreListing findGenreById(@Param("id") Long id);

        @Query("""
            select new cat.tecnocampus.apollofy.track.application.port.in.GenreListing(g.id,g.name)
            from genre g
            """)
    List<GenreListing> findAllGenres();

   /* @Query("""
    select t.id,t.title,t.durationSeconds,t.genres
                from track  t
                where t.id = :trackId

""")
    void deleteGenreFromTrack(Long trackId, Long genreId);*/

    @Query("""
            select new cat.tecnocampus.apollofy.track.application.port.in.PopularGenreListing(
            count(genres),genres.name) from track t inner join t.genres genres group by genres.id order by count(genres) desc
            """)
    List<PopularGenreListing> findMostUsedGenres(Pageable pageable);
}
