package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.domain.Genre;

import java.util.HashSet;
import java.util.Set;

public class MapperGenreGenreListing {
    public static Set<Genre> GenreListingSetToGenreSet(Set<GenreListing> genreListings){
        Set<Genre> genres=new HashSet<>();
        genreListings.stream().forEach(le->genres.add(genreListingToGenre(le)));
        return genres;
    }
    public static Genre genreListingToGenre(GenreListing genreListing){
        Genre genre= new Genre();
       genre.setId(genreListing.id());
       genre.setName(genreListing.name());
        return genre;

    }
    public static Set<GenreListing> GenreSetToGenreListingSet(Set<Genre> genres){
        Set<GenreListing> genreListings=new HashSet<>();
        genres.stream().forEach(le->genreListings.add(genreToGenreListing(le)));
        return genreListings;
    }
    public static GenreListing genreToGenreListing(Genre genre) {
       GenreListing genreListing =
                new GenreListing(genre.getId(),genre.getName());
        return genreListing;
    }

}
