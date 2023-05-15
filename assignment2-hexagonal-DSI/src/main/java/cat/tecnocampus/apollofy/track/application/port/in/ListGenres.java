package cat.tecnocampus.apollofy.track.application.port.in;


import java.util.List;

public interface ListGenres {
    List<GenreListing> getAllGenres();

    GenreListing getGenreById(Long id);

    void deleteGenre(Long id);

    /*void deleteGenreFromTrack(Long trackId, Long genreId);*/

    List<PopularGenreListing> getTopGenresAsInTracks(int size);
}
