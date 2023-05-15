package cat.tecnocampus.apollofy.track.adapter.out.persistance;


import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.PopularGenreListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListGenrePort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchGenreListingAdapter implements ListGenrePort {
    GenreRepository genreRepository;

    public FetchGenreListingAdapter(GenreRepository genreRepository){
        this.genreRepository=genreRepository;
    }

    @Override
    public GenreListing findById(Long id) {
        return genreRepository.findGenreById(id);
    }

    @Override
    public List<GenreListing> findAll() {
        return genreRepository.findAllGenres();
    }
    public void deleteById(Long id){
        genreRepository.deleteById(id);
    }

   public List<PopularGenreListing> findMostUsedGenres(PageRequest of){
       return genreRepository.findMostUsedGenres(of);
   }

}
