package cat.tecnocampus.apollofy.track.adapter.in.web;


import cat.tecnocampus.apollofy.track.adapter.out.persistance.TrackEntity;
import cat.tecnocampus.apollofy.track.application.port.in.ListLikeTrack;
import cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ListLikeTracksController {
    private final ListLikeTrack listLikeTrack;

    public ListLikeTracksController(ListLikeTrack listLikeTrack){
        this.listLikeTrack=listLikeTrack;
    }

    @GetMapping("/api/me/likedTracks")  //OK
    public List<TrackListing> getLikedTracks(Principal principal) {
        return listLikeTrack.getUserLikedTracks(principal.getName());
    }

    @GetMapping("/top/tracks")  //OK
    public List<PopularTrackListing> getPopularTracks(@RequestParam(defaultValue = "3") int size,
                                               @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd") LocalDate from,
                                               @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd") LocalDate to) {

        if (from == null) from = LocalDate.now().minusYears(10);
        if (to == null) to = LocalDate.now().plusDays(1);
        System.out.println("going to return ");
        return listLikeTrack.getPopularTracks(size, from.atStartOfDay(), to.atStartOfDay());
    }


}
