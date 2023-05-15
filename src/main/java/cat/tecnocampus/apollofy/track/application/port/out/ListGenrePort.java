package cat.tecnocampus.apollofy.track.application.port.out;

import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.PopularGenreListing;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ListGenrePort {
   GenreListing findById(Long id);
   List<GenreListing> findAll();
   void deleteById(Long id);
   List<PopularGenreListing> findMostUsedGenres(PageRequest of);
}
