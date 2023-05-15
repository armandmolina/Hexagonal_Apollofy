package cat.tecnocampus.apollofy.track.application.service;

import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.GenreListing;
import cat.tecnocampus.apollofy.track.application.port.in.ListTracks;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.track.application.port.out.ListGenrePort;
import cat.tecnocampus.apollofy.track.application.port.out.ListTrackPort;
import cat.tecnocampus.apollofy.track.application.port.out.StoreTrackPort;
import cat.tecnocampus.apollofy.track.domain.Track;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.service.MapperUserUserListing;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ListTracksService implements ListTracks {

    private final ListTrackPort listTrackPort;
    private final ListGenrePort listGenrePort;
    private final ListUserPort listUserPort;
    private final StoreTrackPort storeTrackPort;

    ListTracksService(ListTrackPort listTrackPort, ListGenrePort listGenrePort, ListUserPort listUserPort, StoreTrackPort storeTrackPort) {
        this.listTrackPort = listTrackPort;
        this.listGenrePort = listGenrePort;
        this.listUserPort = listUserPort;
        this.storeTrackPort = storeTrackPort;
    }

    @Override
    public List<TrackListing> getAllTracks() {
        return listTrackPort.loadAllTracks();
    }

    @Override
    public TrackListing getTrackById(Long id) {
        return listTrackPort.loadTrackById(id);
    }


    @Override
    public void addGenresToTrack(Long id, List<Long> genresId) {
        List<GenreListing> genres = new ArrayList<GenreListing>();
        for(Long genreId: genresId){
            genres.add(listGenrePort.findById(genreId));
        }
        TrackListing trackListing = listTrackPort.loadTrackById(id);
        Track track = MapperTrackTrackListing.trackListingToTrack(trackListing);
        List <cat.tecnocampus.apollofy.track.domain.Genre> genreList= new ArrayList<cat.tecnocampus.apollofy.track.domain.Genre>();

        for (GenreListing g : genres) {
            cat.tecnocampus.apollofy.track.domain.Genre genre = MapperGenreGenreListing.genreListingToGenre(g);
            genreList.add(genre);
        }
        track.addGenres(genreList);
    }

    @Override
    public void addArtistsToTrack(Long trackId, Set<String> artistsName) {
        Set<UserListing> users = new HashSet<UserListing>();
        for(String artistName: artistsName){
            users.add(listUserPort.loadUserByName(artistName));
        }
        TrackListing trackListing = listTrackPort.loadTrackById(trackId);
        Track track = MapperTrackTrackListing.trackListingToTrack(trackListing);
        List <UserFy> userList= new ArrayList<UserFy>();

        for (UserListing u : users) {
            UserFy user = MapperUserUserListing.userListingToUser(u);
            userList.add(user);
        }
        track.setArtists(userList);
    }

    @Override
    public void removeGenreFromTrack(Long trackId, Long genreId) {
        TrackListing tracklisting = listTrackPort.loadTrackById(trackId);
        GenreListing genreListing = tracklisting.genreListings().stream().filter(g -> g.id().equals(genreId)).findFirst().get();
        TrackEntity trackEntity=MapperTrackTrackEntity.trackToTrackEntity(MapperTrackTrackListing.trackListingToTrack(tracklisting));

        trackEntity.removeGenre(MapperGenreGenreListing.genreListingToGenre(genreListing));
        storeTrackPort.storeTrack(trackEntity);
    }

}
