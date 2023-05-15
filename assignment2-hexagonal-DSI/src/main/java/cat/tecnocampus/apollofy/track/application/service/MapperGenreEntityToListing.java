package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.GenreEntity;
import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;

import java.util.HashSet;
import java.util.Set;

public class MapperGenreEntityToListing {
    public static GenreListing genreEntityToGenreListing(GenreEntity genreEntity){
        GenreListing genreListing= new GenreListing(genreEntity.getId(),genreEntity.getName());
    return genreListing;
    }
    public static Set<GenreListing> genreEntitySetToGenreListingSet(Set<GenreEntity> genreEntity){
        Set<GenreListing> genreListing = new HashSet<>();
        genreEntity.forEach(le -> genreListing.add(genreEntityToGenreListing(le)));
        return genreListing;

    }

    public static Set<GenreEntity> genreListingSetToGenreEntitySet(Set<GenreListing> genreListings){
        Set<GenreEntity> genreEntities = new HashSet<>();
        genreListings.forEach(le -> genreEntities.add(genreListingsToGenreEntity(le)));
        return genreEntities;

    }

    public static GenreEntity genreListingsToGenreEntity(GenreListing genreListing){
        GenreEntity genreEntity= new GenreEntity();
        genreEntity.setId(genreListing.id());
        genreEntity.setName(genreListing.name());
        return genreEntity;
    }

}
