package cat.tecnocampus.apollofy.track.adapter.in.web;


import cat.tecnocampus.apollofy.track.application.port.in.ListTracks;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
class ListTracksController {
    private final ListTracks listTracks;

    ListTracksController (ListTracks listTracks) {
        this.listTracks = listTracks;
    }

    @GetMapping("/tracks")  //OK
    public List<TrackListing> getAllTracks() {
        return listTracks.getAllTracks();
    }
    
    @GetMapping("/tracks/{id}") //OK
    public TrackListing getTracksById(@PathVariable Long id) {
        return listTracks.getTrackById(id);
    }

    @PutMapping("/tracks/{id}/genres")
    public void addTrackGenres(@PathVariable Long id, @RequestBody List<Long> genresId) {
        listTracks.addGenresToTrack(id, genresId);
    }

    @PutMapping("/tracks/{trackId}/artists")
    public void addArtistsToTrack(@PathVariable Long trackId, @RequestBody Set<String> artistsEmail) {
        listTracks.addArtistsToTrack(trackId, artistsEmail);
    }

    @DeleteMapping("/tracks/{trackId}/genres/{genreId}")
    public void deleteGenreFromTrack(@PathVariable Long trackId, @PathVariable Long genreId) {
        listTracks.removeGenreFromTrack(trackId, genreId);
    }
}
