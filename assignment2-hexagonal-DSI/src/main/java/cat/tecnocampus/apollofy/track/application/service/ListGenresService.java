package cat.tecnocampus.apollofy.track.application.service;


import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.ListGenres;
import cat.tecnocampus.apollofy.track.application.port.in.PopularGenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListGenrePort;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.domain.Track;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListGenresService implements ListGenres {
    private final ListGenrePort listGenresPort;
    private final ListTrackPort listTrackPort;

    ListGenresService(ListGenrePort listGenrePort, ListTrackPort listTrackPort){

        this.listGenresPort=listGenrePort;
        this.listTrackPort=listTrackPort;

    }
    @Override
    public List<GenreListing> getAllGenres() {
        return listGenresPort.findAll();
    }

    @Override
    public GenreListing getGenreById(Long id) {
        return listGenresPort.findById(id);
    }

    @Override
    public void deleteGenre(Long id) {
        listGenresPort.deleteById(id);
    }
/*
    @Override
    public void deleteGenreFromTrack(Long trackId, Long genreId){
        TrackListing trackListing = listTrackPort.loadTrackById(trackId);
        Track track= MapperTrackTrackListing.trackListingToTrack(trackListing);
       GenreListing genre = trackListing.genreListings() .stream().filter(g -> g.id().equals(genreId)).findFirst().get();
        track.removeGenre(MapperGenreGenreListing.genreListingToGenre(genre));
    }*/
    @Override
    public List<PopularGenreListing> getTopGenresAsInTracks(int size){
       return  listGenresPort.findMostUsedGenres(PageRequest.of(0,size));
    }


}
