package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.GenreEntity;
import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.domain.Genre;

import java.util.HashSet;
import java.util.Set;

public class MapperGenreGenreEntity {
    public static Set<GenreEntity> GenreSetToGenreEntitySet(Set<Genre> genres){
        Set<GenreEntity> genreEntities=new HashSet<>();
        genres.stream().forEach(le->genreEntities.add(genreToGenreEntity(le)));
        return genreEntities;
    }
    public static GenreEntity genreToGenreEntity(Genre genre){
        GenreEntity genreEntity= new GenreEntity();
        genreEntity.setId(genre.getId());
        genreEntity.setName(genre.getName());
        return genreEntity;

    }

    public static Set<Genre> GenreEntitySetToGenreSet(Set<GenreEntity> genreEntities) {
        Set<Genre> genres=new HashSet<>();
        genreEntities.stream().forEach(le->genres.add(genreEntityToGenre(le)));
        return genres;
    }

    private static Genre genreEntityToGenre(GenreEntity genreEntity) {
        Genre genre= new Genre();
        genre.setId(genreEntity.getId());
        genre.setName(genreEntity.getName());
        return genre;
    }

}
